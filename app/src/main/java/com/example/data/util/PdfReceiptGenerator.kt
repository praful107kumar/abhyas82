package com.example.data.util

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import androidx.core.content.FileProvider
import com.example.data.model.StudentSessionEntity
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object PdfReceiptGenerator {

    fun generateReceiptPdf(context: Context, session: StudentSessionEntity): File {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // Standard A4 (in points)
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val primaryColor = Color.parseColor("#0D3B66")
        val accentGold = Color.parseColor("#D97706")
        val successGreen = Color.parseColor("#16A34A")
        val textColor = Color.parseColor("#0F172A")
        val subTextColor = Color.parseColor("#475569")
        val lightBg = Color.parseColor("#F1F5F9")

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        // Outer Decorative Border
        paint.color = primaryColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3f
        canvas.drawRect(30f, 30f, 565f, 812f, paint)

        // Inner Border
        paint.color = accentGold
        paint.strokeWidth = 1f
        canvas.drawRect(36f, 36f, 559f, 806f, paint)

        // Header Background Banner
        paint.style = Paint.Style.FILL
        paint.color = primaryColor
        canvas.drawRect(40f, 40f, 555f, 160f, paint)

        // Institute Title
        paint.color = Color.WHITE
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        paint.textSize = 28f
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText("ABHYAS COACHING", 595f / 2, 85f, paint)

        // Subtitle
        paint.textSize = 17f
        paint.color = Color.parseColor("#FDE68A")
        canvas.drawText("Class 10 Science Test Series", 595f / 2, 115f, paint)

        // Academic Session & Motto
        paint.textSize = 11f
        paint.color = Color.WHITE
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        canvas.drawText("CBSE Academic Curriculum • Excellence Through Practice", 595f / 2, 140f, paint)

        // Document Title
        paint.color = primaryColor
        paint.textSize = 18f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText("OFFICIAL ENROLMENT & PAYMENT RECEIPT", 595f / 2, 200f, paint)

        // Horizontal divider line
        paint.color = accentGold
        paint.strokeWidth = 2f
        canvas.drawLine(80f, 215f, 515f, 215f, paint)

        // Receipt Details Box
        paint.color = lightBg
        paint.style = Paint.Style.FILL
        canvas.drawRoundRect(60f, 240f, 535f, 470f, 8f, 8f, paint)

        // Details labels & values
        val dateStr = SimpleDateFormat("dd MMMM yyyy, hh:mm a", Locale.getDefault()).format(Date(session.activationDate))
        val details = listOf(
            "Student Name:" to session.studentName,
            "Student Email:" to session.studentEmail,
            "Course / Stream:" to "Class 10 CBSE Science (Physics, Chemistry, Biology)",
            "Course Fee (Paid):" to "${session.paymentAmount} via PhonePe UPI",
            "Merchant / Payee:" to "${session.payeeName} (PhonePe)",
            "Transaction / UTR ID:" to session.referenceId,
            "Payment Status:" to "VERIFIED & ACTIVE (FULL PASS)",
            "Backend Verification:" to "Supabase Cloud Database",
            "Issue Date & Time:" to dateStr
        )

        paint.textAlign = Paint.Align.LEFT
        var curY = 275f

        for ((label, value) in details) {
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12f
            paint.color = subTextColor
            canvas.drawText(label, 80f, curY, paint)

            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            paint.textSize = 12.5f
            paint.color = if (label.contains("Status")) successGreen else textColor
            canvas.drawText(value, 245f, curY, paint)

            curY += 24f
        }

        // Coaching Faculty & Administration Box
        paint.style = Paint.Style.STROKE
        paint.color = Color.parseColor("#CBD5E1")
        paint.strokeWidth = 1f
        canvas.drawRoundRect(60f, 495f, 535f, 620f, 8f, 8f, paint)

        paint.style = Paint.Style.FILL
        paint.color = primaryColor
        paint.textSize = 14f
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText("ACADEMIC ADMINISTRATION", 80f, 525f, paint)

        paint.textSize = 13f
        paint.color = textColor
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText("Given by: Praful Kumar", 80f, 560f, paint)
        paint.textSize = 11f
        paint.color = subTextColor
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        canvas.drawText("Senior Academic Mentor & Science Faculty", 80f, 578f, paint)

        paint.textSize = 13f
        paint.color = textColor
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        canvas.drawText("Director: Anuj Sir", 330f, 560f, paint)
        paint.textSize = 11f
        paint.color = subTextColor
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        canvas.drawText("Founder & Academic Director, Abhyas Coaching", 330f, 578f, paint)

        // Seal / Verification Badge
        paint.style = Paint.Style.STROKE
        paint.color = accentGold
        paint.strokeWidth = 2f
        canvas.drawCircle(595f / 2, 690f, 42f, paint)
        paint.strokeWidth = 1f
        canvas.drawCircle(595f / 2, 690f, 38f, paint)

        paint.style = Paint.Style.FILL
        paint.textAlign = Paint.Align.CENTER
        paint.color = accentGold
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        paint.textSize = 9f
        canvas.drawText("ABHYAS COACHING", 595f / 2, 678f, paint)
        paint.textSize = 11f
        paint.color = successGreen
        canvas.drawText("★ VERIFIED ★", 595f / 2, 693f, paint)
        paint.textSize = 8.5f
        paint.color = primaryColor
        canvas.drawText("OFFICIAL SEAL", 595f / 2, 706f, paint)

        // Footer Note
        paint.textSize = 9.5f
        paint.color = subTextColor
        paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC)
        canvas.drawText("This computer-generated receipt is authentic and confirms lifetime offline access to the Science Test Series.", 595f / 2, 765f, paint)
        canvas.drawText("For inquiries: contact@abhyascoaching.com • Designed for CBSE Board Examination Aspirants", 595f / 2, 782f, paint)

        pdfDocument.finishPage(page)

        val receiptsDir = File(context.cacheDir, "receipts").apply { mkdirs() }
        val receiptFile = File(receiptsDir, "Abhyas_Receipt_${session.referenceId}.pdf")
        val outputStream = FileOutputStream(receiptFile)
        pdfDocument.writeTo(outputStream)
        outputStream.flush()
        outputStream.close()
        pdfDocument.close()

        return receiptFile
    }

    fun shareReceiptPdf(context: Context, pdfFile: File) {
        val uri = FileProvider.getUriForFile(
            context,
            "com.aistudio.abhyascoaching.scitst.fileprovider",
            pdfFile
        )
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "application/pdf"
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_SUBJECT, "Abhyas Coaching - Class 10 Science Test Series Receipt")
            putExtra(Intent.EXTRA_TEXT, "Here is your official Class 10 Science Test Series receipt from Abhyas Coaching.")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        val chooser = Intent.createChooser(shareIntent, "Share Receipt PDF")
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(chooser)
    }

    fun viewReceiptPdf(context: Context, pdfFile: File) {
        val uri = FileProvider.getUriForFile(
            context,
            "com.aistudio.abhyascoaching.scitst.fileprovider",
            pdfFile
        )
        val viewIntent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/pdf")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            context.startActivity(viewIntent)
        } catch (e: Exception) {
            // Fallback to share chooser if no dedicated PDF viewer is registered
            shareReceiptPdf(context, pdfFile)
        }
    }
}
