# -*- coding: utf-8 -*-
import json
import os

chapters_meta = [
    {
        "id": 1,
        "title": "Chemical Reactions and Equations",
        "subject": "Chemistry",
        "topics": [
            "Balancing Chemical Equations",
            "Combination Reactions",
            "Decomposition Reactions (Thermal, Electrolytic, Photochemical)",
            "Displacement Reactions & Activity Series",
            "Double Displacement & Precipitation Reactions",
            "Oxidation, Reduction and Redox Reactions",
            "Corrosion Prevention and Rancidity",
            "Exothermic and Endothermic Reactions"
        ]
    },
    {
        "id": 2,
        "title": "Acids, Bases and Salts",
        "subject": "Chemistry",
        "topics": [
            "Indicators (Litmus, Methyl Orange, Phenolphthalein, Olfactory)",
            "Reaction of Acids with Metals and Carbonates",
            "pH Scale and Universal Indicator",
            "Importance of pH in Daily Life (Tooth decay, Acid rain, Digestive system)",
            "Chlor-Alkali Process and Products (NaOH, Cl2, H2)",
            "Bleaching Powder (CaOCl2) Preparation and Uses",
            "Baking Soda (NaHCO3) and Washing Soda (Na2CO3.10H2O)",
            "Plaster of Paris (CaSO4.1/2H2O) and Water of Crystallization"
        ]
    },
    {
        "id": 3,
        "title": "Metals and Non-metals",
        "subject": "Chemistry",
        "topics": [
            "Physical Properties (Malleability, Ductility, Conductivity)",
            "Chemical Properties of Metals (Reaction with O2, H2O, Acids)",
            "Amphoteric Oxides (Al2O3, ZnO)",
            "Reactivity Series and Displacement Tendency",
            "Formation of Ionic Compounds and Properties (High MP, Conductivity)",
            "Occurrence and Extraction of Metals (Roasting, Calcination)",
            "Reduction by Carbon and Electrolytic Refining of Copper",
            "Corrosion of Metals and Alloy Formation (Steel, Brass, Bronze, Solder)"
        ]
    },
    {
        "id": 4,
        "title": "Carbon and its Compounds",
        "subject": "Chemistry",
        "topics": [
            "Covalent Bonding and Lewis Electron Dot Structures",
            "Versatile Nature of Carbon (Catenation and Tetravalency)",
            "Allotropes of Carbon (Diamond, Graphite, Fullerenes)",
            "Saturated and Unsaturated Hydrocarbons (Alkanes, Alkenes, Alkynes)",
            "Homologous Series and Structural Isomerism",
            "Functional Groups (Halogen, Alcohol, Aldehyde, Ketone, Carboxylic Acid)",
            "Chemical Properties (Combustion, Oxidation, Addition, Substitution)",
            "Ethanol and Ethanoic Acid Reactions (Esterification & Saponification)",
            "Soaps, Detergents and Cleansing Action of Micelles"
        ]
    },
    {
        "id": 5,
        "title": "Life Processes",
        "subject": "Biology",
        "topics": [
            "Autotrophic Nutrition and Photosynthesis Mechanism (Light & Dark reaction)",
            "Stomatal Opening and Closing Mechanism",
            "Heterotrophic Nutrition (Amoeba, Paramecium, Fungi)",
            "Human Alimentary Canal and Digestive Enzymes (Pepsin, Trypsin, Amylase)",
            "Aerobic vs Anaerobic Respiration Pathways and ATP Generation",
            "Human Respiratory System and Alveoli Surface Exchange",
            "Human Circulatory System (Heart Chambers, Valves, Double Circulation)",
            "Blood Vessels and Lymphatic Fluid Function",
            "Transportation in Plants (Xylem Tracheids, Phloem Translocation)",
            "Human Excretory System, Nephron Filtration and Artificial Dialysis"
        ]
    },
    {
        "id": 6,
        "title": "Control and Coordination",
        "subject": "Biology",
        "topics": [
            "Structure of Neuron (Dendrite, Cyton, Axon, Synapse)",
            "Nerve Impulse Transmission and Synaptic Cleft",
            "Reflex Arc and Reflex Action Mechanism",
            "Human Brain Anatomy (Cerebrum, Cerebellum, Medulla Oblongata, Hypothalamus)",
            "Protection of Brain and Spinal Cord (Meninges & CSF)",
            "Plant Tropic Movements (Phototropism, Geotropism, Hydrotropism, Thigmotropism)",
            "Plant Hormones (Auxins, Gibberellins, Cytokinins, Abscisic Acid)",
            "Human Endocrine Glands and Hormones (Pituitary, Thyroid, Pancreas, Adrenal, Gonads)",
            "Feedback Mechanism of Hormonal Regulation (Insulin & Blood Glucose)"
        ]
    },
    {
        "id": 7,
        "title": "How do Organisms Reproduce?",
        "subject": "Biology",
        "topics": [
            "Importance of DNA Copying and Genetic Variations",
            "Asexual Reproduction (Binary Fission, Multiple Fission, Budding)",
            "Spore Formation, Fragmentation and Regeneration in Planaria",
            "Vegetative Propagation in Plants (Natural & Artificial Layering/Grafting)",
            "Sexual Reproduction in Flowering Plants (Carpel, Stamen, Pollination)",
            "Double Fertilization, Seed Formation and Fruit Development",
            "Male Reproductive System (Testes, Vas Deferens, Prostate, Scrotum)",
            "Female Reproductive System (Ovaries, Fallopian Tube, Uterus, Cervix)",
            "Menstrual Cycle and Fertilization Process",
            "Reproductive Health, Contraceptive Methods (Barrier, Chemical, Surgical) and STDs"
        ]
    },
    {
        "id": 8,
        "title": "Heredity",
        "subject": "Biology",
        "topics": [
            "Accumulation of Variation During Reproduction",
            "Mendel's Monohybrid Cross (Law of Segregation, 3:1 Phenotypic, 1:2:1 Genotypic)",
            "Mendel's Dihybrid Cross (Law of Independent Assortment, 9:3:3:1 Ratio)",
            "Dominant vs Recessive Alleles and Traits",
            "Genotype vs Phenotype Identification",
            "Mechanism of Gene Expression and Protein Synthesis Role",
            "Sex Determination in Humans (XX and XY Chromosomes, 50% Probability)",
            "Environmental and Temperature-Dependent Sex Determination in Reptiles"
        ]
    },
    {
        "id": 9,
        "title": "Light – Reflection and Refraction",
        "subject": "Physics",
        "topics": [
            "Laws of Reflection and Spherical Mirrors (Concave & Convex)",
            "Ray Diagrams for Concave Mirror at Various Object Positions",
            "Ray Diagrams for Convex Mirror and Real-World Applications (Rearview mirrors)",
            "Mirror Formula (1/v + 1/u = 1/f) and Sign Conventions",
            "Magnification of Mirrors (m = -v/u = h'/h)",
            "Refraction of Light, Snell's Law and Refractive Index (n = c/v)",
            "Refraction Through Rectangular Glass Slab and Lateral Displacement",
            "Spherical Lenses (Convex & Concave) and Principal Focus",
            "Lens Formula (1/v - 1/u = 1/f) and Magnification (m = v/u)",
            "Power of Lens (P = 1/f in meters, Dioptre Unit) and Combination of Lenses"
        ]
    },
    {
        "id": 10,
        "title": "The Human Eye and the Colorful World",
        "subject": "Physics",
        "topics": [
            "Structure and Working of the Human Eye (Cornea, Iris, Pupil, Crystalline Lens, Retina)",
            "Power of Accommodation and Near Point / Far Point of Normal Eye",
            "Myopia (Short-sightedness), Causes and Concave Lens Correction",
            "Hypermetropia (Far-sightedness), Causes and Convex Lens Correction",
            "Presbyopia and Astigmatism (Bifocal and Cylindrical Lenses)",
            "Refraction of Light Through a Triangular Glass Prism",
            "Dispersion of White Light, VIBGYOR and Recombination of Spectrum (Newton's Prism Experiment)",
            "Formation of Natural Rainbow (Dispersion, Refraction, Internal Reflection)",
            "Atmospheric Refraction (Twinkling of Stars, Advanced Sunrise and Delayed Sunset)",
            "Tyndall Effect and Scattering of Light (Why the sky is blue, Red color of sun at sunrise/sunset)"
        ]
    },
    {
        "id": 11,
        "title": "Electricity",
        "subject": "Physics",
        "topics": [
            "Electric Charge (Q = ne, Q = It) and Electric Current (Ampere)",
            "Electric Potential and Potential Difference (V = W/Q, Voltmeter)",
            "Ohm's Law (V = IR) and V-I Graph Characteristics",
            "Factors Affecting Resistance (R = rho * L / A) and Resistivity",
            "Resistors in Series Combination (Rs = R1 + R2 + R3, Constant Current)",
            "Resistors in Parallel Combination (1/Rp = 1/R1 + 1/R2 + 1/R3, Constant Voltage)",
            "Heating Effect of Electric Current and Joule's Law of Heating (H = I^2 R t)",
            "Practical Applications of Heating Effect (Electric iron, toaster, fuse wire)",
            "Electric Power (P = VI = I^2 R = V^2 / R) and Energy Calculations",
            "Commercial Unit of Electric Energy (1 kWh = 3.6 x 10^6 J, Electricity Bill Calculation)"
        ]
    },
    {
        "id": 12,
        "title": "Magnetic Effects of Electric Current",
        "subject": "Physics",
        "topics": [
            "Magnetic Field and Field Lines (Properties, Direction, Tangent Rule)",
            "Oersted's Experiment and Magnetic Field Due to Straight Current-Carrying Conductor",
            "Maxwell's Right-Hand Thumb Rule",
            "Magnetic Field Due to Current Through Circular Loop and Solenoid",
            "Electromagnet Construction and Comparison with Permanent Magnet",
            "Force on a Current-Carrying Conductor in a Magnetic Field (F = BIl)",
            "Fleming's Left-Hand Rule (Thumb-Motion, Forefinger-Field, Middle-Current)",
            "Domestic Electric Circuits (Live wire, Neutral wire, Earth wire color codes)",
            "Function of Grounding/Earthing and Electric Fuse Safety",
            "Short Circuit and Overloading Causes and Protection"
        ]
    },
    {
        "id": 13,
        "title": "Our Environment",
        "subject": "Natural Resources",
        "topics": [
            "Ecosystem Components (Biotic: Producers, Consumers, Decomposers; Abiotic: Soil, Water, Sunlight)",
            "Food Chains and Food Webs in Terrestrial and Aquatic Habitats",
            "Trophic Levels and Unidirectional Flow of Energy in Ecosystems",
            "Lindeman's 10 Percent Law of Energy Transfer (Energy Loss at Each Step)",
            "Biological Magnification of Toxic Chemicals (Pesticides, DDT Accumulation)",
            "Ozone Layer (O3) Formation and Protection Against UV Radiations",
            "Ozone Depletion by Chlorofluorocarbons (CFCs) and Montreal Protocol (1987)",
            "Waste Management: Biodegradable vs Non-biodegradable Substances",
            "Methods of Safe Garbage Disposal (Landfills, Recycling, Incineration, Composting)",
            "Environmental Impact of Disposable Plastic vs Earthen Cups (Kulhads)"
        ]
    }
]

print(f"Loaded metadata for {len(chapters_meta)} chapters.")
