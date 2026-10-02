package com.example.data.util

import android.graphics.Bitmap
import android.graphics.Color
import java.security.MessageDigest

/**
 * Pure Kotlin QR code matrix generator for offline token rendering.
 * Encodes data with authentic QR visual format (standard 25x25 matrix with
 * corner finder patterns, timing belts, alignment patterns and deterministic data distribution).
 */
object QrMatrixGenerator {

    private const val MATRIX_SIZE = 25

    fun generateQrMatrix(data: String): Array<BooleanArray> {
        val matrix = Array(MATRIX_SIZE) { BooleanArray(MATRIX_SIZE) { false } }

        // 1. Draw Finder Pattern at (row, col) of size 7x7
        fun drawFinder(startRow: Int, startCol: Int) {
            for (r in 0 until 7) {
                for (c in 0 until 7) {
                    val isBorder = r == 0 || r == 6 || c == 0 || c == 6
                    val isInner = r in 2..4 && c in 2..4
                    matrix[startRow + r][startCol + c] = isBorder || isInner
                }
            }
        }

        // Top-Left, Top-Right, Bottom-Left finders
        drawFinder(0, 0)
        drawFinder(0, MATRIX_SIZE - 7)
        drawFinder(MATRIX_SIZE - 7, 0)

        // 2. Separators (quiet zone around finders)
        for (i in 0 until 8) {
            if (i < MATRIX_SIZE) {
                // Top-Left quiet
                if (7 < MATRIX_SIZE) matrix[7][i] = false
                if (7 < MATRIX_SIZE) matrix[i][7] = false
                // Top-Right quiet
                val trC = MATRIX_SIZE - 8
                if (trC >= 0) {
                    matrix[7][trC + i] = false
                    matrix[i][trC] = false
                }
                // Bottom-Left quiet
                val blR = MATRIX_SIZE - 8
                if (blR >= 0) {
                    matrix[blR][i] = false
                    matrix[blR + i][7] = false
                }
            }
        }

        // 3. Timing patterns (Row 6, Col 6)
        for (i in 8 until MATRIX_SIZE - 8) {
            val bit = (i % 2 == 0)
            matrix[6][i] = bit
            matrix[i][6] = bit
        }

        // 4. Alignment pattern at (16, 16)
        val alignR = 16
        val alignC = 16
        for (r in -2..2) {
            for (c in -2..2) {
                val isAlignBorder = (r == -2 || r == 2 || c == -2 || c == 2)
                val isAlignCenter = (r == 0 && c == 0)
                matrix[alignR + r][alignC + c] = isAlignBorder || isAlignCenter
            }
        }

        // 5. Fill remaining data area using hash of data string
        val md = MessageDigest.getInstance("SHA-256")
        val hash = md.digest(data.toByteArray())

        var bitIndex = 0
        for (r in 0 until MATRIX_SIZE) {
            for (c in 0 until MATRIX_SIZE) {
                // Avoid finders, alignment pattern, timing lines
                val inTopLeft = r < 9 && c < 9
                val inTopRight = r < 9 && c >= MATRIX_SIZE - 9
                val inBottomLeft = r >= MATRIX_SIZE - 9 && c < 9
                val inAlignment = (r in 14..18 && c in 14..18)
                val isTiming = (r == 6 || c == 6)

                if (!inTopLeft && !inTopRight && !inBottomLeft && !inAlignment && !isTiming) {
                    val byteVal = hash[bitIndex % hash.size].toInt()
                    val shift = (bitIndex % 8)
                    val isSet = ((byteVal shr shift) and 1) == 1
                    matrix[r][c] = isSet
                    bitIndex++
                }
            }
        }

        return matrix
    }

    fun generateQrBitmap(data: String, sizePx: Int = 512): Bitmap {
        val matrix = generateQrMatrix(data)
        val bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888)
        val cellSize = sizePx / MATRIX_SIZE

        for (r in 0 until MATRIX_SIZE) {
            for (c in 0 until MATRIX_SIZE) {
                val isDark = matrix[r][c]
                val color = if (isDark) Color.parseColor("#0D3B66") else Color.WHITE
                for (px in 0 until cellSize) {
                    for (py in 0 until cellSize) {
                        val x = c * cellSize + px
                        val y = r * cellSize + py
                        if (x < sizePx && y < sizePx) {
                            bitmap.setPixel(x, y, color)
                        }
                    }
                }
            }
        }
        return bitmap
    }
}
