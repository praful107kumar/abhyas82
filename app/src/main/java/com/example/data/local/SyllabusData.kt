package com.example.data.local

import com.example.data.model.Chapter

object SyllabusData {
    val chapters: List<Chapter> = listOf(
        Chapter(
            id = 1,
            number = 1,
            title = "Chemical Reactions and Equations",
            subject = "Chemistry",
            description = "Chemical equations, types of chemical reactions: combination, decomposition, displacement, double displacement, precipitation, neutralization, oxidation and reduction, corrosion, and rancidity.",
            keyTopics = listOf("Balancing Chemical Equations", "Decomposition Reactions", "Displacement & Redox", "Corrosion & Rancidity")
        ),
        Chapter(
            id = 2,
            number = 2,
            title = "Acids, Bases and Salts",
            subject = "Chemistry",
            description = "Acids, bases, and salts: definitions in terms of furnishing of H+ and OH- ions, general properties, examples, uses, concept of pH scale, importance of pH in everyday life; preparation and uses of Sodium Hydroxide, Bleaching powder, Baking soda, Washing soda, and Plaster of Paris.",
            keyTopics = listOf("pH Scale & Indicators", "Acid-Base Neutralization", "Baking Soda & Washing Soda", "Plaster of Paris & Water of Crystallization")
        ),
        Chapter(
            id = 3,
            number = 3,
            title = "Metals and Non-metals",
            subject = "Chemistry",
            description = "Properties of metals and non-metals; Reactivity series; Formation and properties of ionic compounds; Basic metallurgical processes; Corrosion and its prevention.",
            keyTopics = listOf("Physical & Chemical Properties", "Reactivity Series & Displacement", "Ionic Bond Formation", "Metallurgy & Calcination/Roasting")
        ),
        Chapter(
            id = 4,
            number = 4,
            title = "Carbon and its Compounds",
            subject = "Chemistry",
            description = "Covalent bonding in carbon compounds, versatile nature of carbon, homologous series, nomenclature of carbon compounds containing functional groups, chemical properties of carbon compounds (combustion, oxidation, addition and substitution reaction), ethanol and ethanoic acid, soaps and detergents.",
            keyTopics = listOf("Covalent Bonds & Tetravalency", "Homologous Series & Isomerism", "Ethanol & Ethanoic Acid", "Soaps, Detergents & Micelle Formation")
        ),
        Chapter(
            id = 5,
            number = 5,
            title = "Life Processes",
            subject = "Biology",
            description = "Basic concept of nutrition, respiration, transport, and excretion in plants and animals; Photosynthesis, Human digestive system, aerobic & anaerobic respiration, human circulatory system, nephron filtration.",
            keyTopics = listOf("Autotrophic & Heterotrophic Nutrition", "Cellular Respiration & ATP", "Human Heart & Double Circulation", "Excretory System & Nephron")
        ),
        Chapter(
            id = 6,
            number = 6,
            title = "Control and Coordination",
            subject = "Biology",
            description = "Tropic movements in plants; Introduction to plant hormones; Control and coordination in animals: Nervous system; Voluntary, involuntary and reflex action; Chemical coordination: animal hormones.",
            keyTopics = listOf("Reflex Arc & Synapse", "Human Brain Anatomy", "Plant Hormones (Auxin, Cytokinin, ABA)", "Endocrine Glands & Hormones")
        ),
        Chapter(
            id = 7,
            number = 7,
            title = "How do Organisms Reproduce?",
            subject = "Biology",
            description = "Reproduction in animals and plants (asexual and sexual), reproductive health - need and methods of family planning; safe sex vs HIV/AIDS; child bearing and women's health.",
            keyTopics = listOf("Asexual Reproduction (Budding, Fission, Spores)", "Pollination & Fertilization in Flowers", "Male & Female Reproductive System", "Reproductive Health & Contraception")
        ),
        Chapter(
            id = 8,
            number = 8,
            title = "Heredity",
            subject = "Biology",
            description = "Heredity; Mendel's contribution - Laws for inheritance of traits: Sex determination: brief introduction (avoiding computation of probabilities).",
            keyTopics = listOf("Mendel's Monohybrid Cross (3:1 / 1:2:1)", "Dihybrid Cross (9:3:3:1)", "Sex Determination in Humans (XX & XY)", "Dominant vs Recessive Traits")
        ),
        Chapter(
            id = 9,
            number = 9,
            title = "Light – Reflection and Refraction",
            subject = "Physics",
            description = "Reflection of light by curved surfaces; Images formed by spherical mirrors, centre of curvature, principal axis, principal focus, focal length, mirror formula, magnification. Refraction; Laws of refraction, refractive index, lens formula, power of a lens.",
            keyTopics = listOf("Spherical Mirrors & Ray Diagrams", "Mirror Formula & Sign Convention", "Refraction & Snell's Law", "Lens Formula & Power of Lens (Dioptres)")
        ),
        Chapter(
            id = 10,
            number = 10,
            title = "The Human Eye and the Colourful World",
            subject = "Physics",
            description = "Functioning of a lens in human eye, defects of vision and their corrections, applications of spherical mirrors and lenses. Refraction of light through a prism, dispersion of light, scattering of light, applications in daily life (twinkling of stars, blue color of sky).",
            keyTopics = listOf("Myopia & Hypermetropia Correction", "Dispersion of White Light via Prism", "Atmospheric Refraction & Star Twinkling", "Tyndall Effect & Blue Sky Scattering")
        ),
        Chapter(
            id = 11,
            number = 11,
            title = "Electricity",
            subject = "Physics",
            description = "Electric current, potential difference, electric current. Ohm's law; Resistance, Resistivity, Factors on which the resistance of a conductor depends. Series combination of resistors, parallel combination of resistors and its applications in daily life. Heating effect of electric current and its applications in daily life. Electric power, Interrelation between P, V, I and R.",
            keyTopics = listOf("Ohm's Law & V-I Graph", "Resistivity & Temperature Dependence", "Series vs Parallel Combinations", "Joule's Heating & Electric Power (P=VI, P=I²R)")
        ),
        Chapter(
            id = 12,
            number = 12,
            title = "Magnetic Effects of Electric Current",
            subject = "Physics",
            description = "Magnetic field, field lines, field due to a current carrying conductor, field due to current carrying coil or solenoid; Force on current carrying conductor, Fleming's Left Hand Rule, Direct current. Alternating current: frequency of AC. Advantage of AC over DC. Domestic electric circuits.",
            keyTopics = listOf("Magnetic Field Lines & Properties", "Right Hand Thumb Rule & Solenoid", "Fleming's Left Hand Rule & Motor Principle", "Domestic Electric Circuits & Fuse/Earth Wire")
        ),
        Chapter(
            id = 13,
            number = 13,
            title = "Our Environment",
            subject = "Natural Resources",
            description = "Eco-system, Environmental problems, Ozone depletion, waste production and their solutions. Biodegradable and non-biodegradable substances. Food chain and food webs, 10 percent energy law.",
            keyTopics = listOf("Ecosystem & Trophic Levels", "10% Energy Transfer Law", "Biological Magnification of Pesticides", "Ozone Layer Depletion & CFCs")
        )
    )
}
