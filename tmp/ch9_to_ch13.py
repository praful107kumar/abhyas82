# -*- coding: utf-8 -*-

def add_ch9_to_ch13(add_q):
    # ==========================================
    # CHAPTER 9: Light – Reflection and Refraction (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C9_P_1", 9, "Light – Reflection and Refraction", "Convex Rear-View Mirror", "PRACTICE", "MCQ",
          "Convex mirrors are universally preferred as rear-view mirrors in automobiles because:",
          ["They always give an erect diminished image and have a much wider field of view", "They form inverted magnified images", "They have zero focal length", "They absorb glare"], 0,
          "Curving outwards allows convex mirrors to capture a broader panorama with upright virtual images.", 1, "Easy", "Optical Applications")
    add_q("C9_P_2", 9, "Light – Reflection and Refraction", "Power of Lens Calculation", "PRACTICE", "MCQ",
          "A corrective lens has a focal length of -50 cm (-0.5 m). Its optical power in dioptres and lens nature are:",
          ["-2.0 D; Concave (diverging)", "+2.0 D; Convex (converging)", "-0.5 D; Concave", "+0.5 D; Bifocal"], 0,
          "P = 1/f(m) = 1/(-0.5) = -2.0 Dioptres. Negative power and focal length denote a concave lens.", 1, "Medium", "Lens Formula")
    add_q("C9_P_3", 9, "Light – Reflection and Refraction", "Snell's Law of Refraction", "PRACTICE", "MCQ",
          "When light travels obliquely from an optically rarer medium (air) to an optically denser medium (glass), the ray:",
          ["Bends towards the normal because its speed decreases in glass", "Bends away from normal as speed increases", "Passes straight without deviation", "Undergoes complete absorption"], 0,
          "v_glass < v_air; by Snell's law (n1 sin i = n2 sin r), angle of refraction r is less than angle of incidence i.", 1, "Medium", "Refraction Basics")
    add_q("C9_P_4", 9, "Light – Reflection and Refraction", "Concave Mirror Virtual Image", "PRACTICE", "MCQ",
          "To obtain an erect, magnified, virtual image of a face using a concave shaving mirror, where must the face be positioned?",
          ["Between the pole (P) and principal focus (F)", "At the centre of curvature (C)", "Beyond C", "At infinity"], 0,
          "Placing an object within the focal length (between P and F) produces a virtual, erect, magnified image behind the mirror.", 1, "Medium", "Ray Diagram")
    add_q("C9_P_5", 9, "Light – Reflection and Refraction", "Mirror Formula Sign Convention", "PRACTICE", "MCQ",
          "The mirror formula relating image distance (v), object distance (u), and focal length (f) is:",
          ["1/v + 1/u = 1/f", "1/v - 1/u = 1/f", "v + u = f", "1/f = u / v"], 0,
          "For spherical mirrors, 1/v + 1/u = 1/f. (By comparison, lens formula is 1/v - 1/u = 1/f).", 1, "Easy", "Formula Recall")
    add_q("C9_P_6", 9, "Light – Reflection and Refraction", "Refractive Index and Speed of Light", "PRACTICE", "MCQ",
          "If the refractive index of diamond is 2.42 and speed of light in vacuum is 3 x 10^8 m/s, speed of light in diamond is:",
          ["1.24 x 10^8 m/s", "2.42 x 10^8 m/s", "3.00 x 10^8 m/s", "0.81 x 10^8 m/s"], 0,
          "v = c / n = (3 x 10^8 m/s) / 2.42 = 1.24 x 10^8 m/s. Light travels slowest in diamond among common media.", 1, "Medium", "Refractive Calculation")

    # TEST_1 (6)
    add_q("C9_T1_1", 9, "Light – Reflection and Refraction", "Magnification Formula for Mirrors", "TEST_1", "MCQ",
          "Linear magnification (m) produced by a spherical mirror in terms of object distance (u) and image distance (v) is given by:",
          ["m = - v / u = h' / h", "m = + v / u", "m = u / v", "m = - u / v"], 0,
          "For spherical mirrors, m = -v/u. A negative magnification signifies a real inverted image.", 1, "Easy", "Magnification Concept")
    add_q("C9_T1_2", 9, "Light – Reflection and Refraction", "Centre of Curvature Object Position", "TEST_1", "MCQ",
          "When an illuminated candle is placed at the centre of curvature (C) of a concave mirror, the image is formed:",
          ["At C, real, inverted, and of the same size as the object", "At infinity", "Between P and F", "Behind the mirror"], 0,
          "At C, reflected rays converge exactly at C, yielding an inverted real image with magnification m = -1.", 1, "Medium", "Concave Ray Mechanics")
    add_q("C9_T1_3", 9, "Light – Reflection and Refraction", "Lateral Displacement in Glass Slab", "TEST_1", "MCQ",
          "When a ray of light passes through a parallel-sided rectangular glass slab, the emergent ray is:",
          ["Parallel to the incident ray but laterally displaced sideways", "Perpendicular to incident ray", "Bent at 90 degrees", "Dispersion into rainbow"], 0,
          "Because the two opposing refracting faces are parallel, angle of incidence equals angle of emergence, causing lateral shift.", 1, "Medium", "Slab Refraction")
    add_q("C9_T1_4", 9, "Light – Reflection and Refraction", "Convex Lens Converging Rays", "TEST_1", "MCQ",
          "A convex lens of focal length 20 cm forms a real image of the same size as the object when the object is placed at:",
          ["40 cm (at 2F1)", "20 cm (at F1)", "10 cm", "Infinity"], 0,
          "Object at 2F forms real, inverted image at 2F on other side with same size (m = -1). 2 x 20 cm = 40 cm.", 1, "Medium", "Lens Focal Calculation")
    add_q("C9_T1_5", 9, "Light – Reflection and Refraction", "Relative Refractive Index", "TEST_1", "MCQ",
          "The refractive index of glass with respect to water (w_n_g) is expressed as:",
          ["n_glass / n_water (or v_water / v_glass)", "n_water / n_glass", "n_glass * n_water", "v_glass / v_water"], 0,
          "Relative refractive index w_n_g = v_water / v_glass = n_glass / n_water.", 1, "Medium", "Wave Optics")
    add_q("C9_T1_6", 9, "Light – Reflection and Refraction", "Solar Furnace Mirror", "TEST_1", "MCQ",
          "Large concave mirrors are used in solar furnaces and solar cookers because they:",
          ["Concentrate parallel rays of sunlight to a single intense focal point generating high temperatures", "Spread light over large area", "Polarise sunlight", "Absorb infrared rays only"], 0,
          "Concave parabolic reflectors focus sunlight onto the crucible placed at focal point F, exceeding 3000°C.", 1, "Easy", "Solar Application")

    # TEST_2 (6)
    add_q("C9_T2_1", 9, "Light – Reflection and Refraction", "Combination of Lenses Power", "TEST_2", "COMPETENCY_BASED",
          "An optician places a convex lens of power +3.5 D in contact with a concave lens of power -1.5 D. The net power and focal length of the combination are:",
          ["+2.0 D and +50 cm (+0.5 m)", "-2.0 D and -50 cm", "+5.0 D and +20 cm", "+1.0 D and +100 cm"], 0,
          "P_net = P1 + P2 = +3.5 - 1.5 = +2.0 D. f_net = 1 / P = 1 / 2.0 = +0.5 m = +50 cm (convex system).", 1, "Hard", "Optics Problem Solving")
    add_q("C9_T2_2", 9, "Light – Reflection and Refraction", "Magnification Analysis", "TEST_2", "COMPETENCY_BASED",
          "If the magnification produced by a spherical mirror is m = +0.8, what can you definitively conclude about the mirror and image?",
          ["It is a convex mirror producing a virtual, erect, and diminished image", "It is a concave mirror producing real image", "It is a plane mirror", "It is inverted"], 0,
          "Positive sign denotes virtual and erect; magnitude < 1 denotes diminished. Only convex mirrors yield diminished virtual images.", 1, "Hard", "Sign Convention Analysis")
    add_q("C9_T2_3", 9, "Light – Reflection and Refraction", "Dentist Mirror Choice", "TEST_2", "COMPETENCY_BASED",
          "Dentists hold a small concave mirror close inside a patient's mouth to inspect cavities because:",
          ["When held within focal distance, it produces an erect, magnified, virtual image of the tooth", "It shines ultraviolet light", "It inverts the tooth view", "It filters saliva"], 0,
          "Concave mirror held close (u < f) magnifies tiny tooth fissures clearly.", 1, "Medium", "Clinical Instrument")
    add_q("C9_T2_4", 9, "Light – Reflection and Refraction", "Refraction Apparent Depth", "TEST_2", "COMPETENCY_BASED",
          "A coin placed at the bottom of a water tank appears raised when viewed from above. This optical illusion is caused by:",
          ["Refraction of light rays bending away from normal as they exit denser water into rarer air", "Reflection from tank walls", "Total internal reflection", "Diffraction"], 0,
          "Rays originating at the coin bend away from normal at the water-air interface, projecting an apparent virtual depth shallower than real depth.", 1, "Medium", "Apparent Depth Phenomenon")
    add_q("C9_T2_5", 9, "Light – Reflection and Refraction", "Radius of Curvature Relation", "TEST_2", "COMPETENCY_BASED",
          "For spherical mirrors of small aperture, the radius of curvature (R) and focal length (f) are related by:",
          ["R = 2 f (or f = R / 2)", "f = 2 R", "R = f^2", "R * f = 1"], 0,
          "The principal focus F lies midway between the pole P and center of curvature C.", 1, "Easy", "Geometric Optics")
    add_q("C9_T2_6", 9, "Light – Reflection and Refraction", "Burning Paper with Convex Lens", "TEST_2", "COMPETENCY_BASED",
          "Holding a magnifying glass (convex lens) towards the sun focuses bright sunlight onto a small spot on a sheet of dry paper, which soon catches fire. Why?",
          ["Parallel solar rays converge at the principal focus F, concentrating immense radiant thermal energy on a tiny spot", "The glass lens heats up", "Paper absorbs air", "UV rays ignite carbon"], 0,
          "Convergence of parallel solar rays at the focal point concentrates solar heat, exceeding paper ignition temperature.", 1, "Easy", "Ray Convergence")

    # TEST_3 (6)
    add_q("C9_T3_1", 9, "Light – Reflection and Refraction", "Assertion on Convex Mirror Focus", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): The focal length of a convex mirror is always taken as positive in the Cartesian sign convention.\nReason (R): The principal focus of a convex mirror lies behind the mirror on the right side of the pole along the positive x-axis.",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "Convex mirror curves outwards; focus is virtual and situated behind mirror (+x direction).", 1, "Medium", "Board Pattern A/R")
    add_q("C9_T3_2", 9, "Light – Reflection and Refraction", "Lens Formula Calculation", "TEST_3", "CASE_BASED",
          "An object is placed 30 cm in front of a concave lens of focal length 15 cm. Where is the virtual image formed?",
          ["-10 cm (10 cm in front of the lens on same side)", "+10 cm", "-30 cm", "+15 cm"], 0,
          "1/v - 1/u = 1/f => 1/v = 1/f + 1/u = 1/(-15) + 1/(-30) = -3/30 = -1/10 => v = -10 cm.", 1, "Hard", "Numerical Optics")
    add_q("C9_T3_3", 9, "Light – Reflection and Refraction", "Headlight Reflector Position", "TEST_3", "CASE_BASED",
          "In motor vehicle headlights and searchlights, the high-power bulb is positioned precisely at:",
          ["The principal focus (F) of a concave reflector", "The center of curvature (C)", "The pole (P)", "Between P and F"], 0,
          "Rays originating at the focus F reflect off the concave parabolic surface as a parallel, intense beam traveling long distances.", 1, "Medium", "Applied Ray Optics")
    add_q("C9_T3_4", 9, "Light – Reflection and Refraction", "Critical Angle and Total Internal Reflection", "TEST_3", "CASE_BASED",
          "When light travels from an optically denser medium to rarer medium at an angle of incidence greater than the critical angle, it undergoes:",
          ["Total Internal Reflection (TIR)", "Refraction along the boundary", "Absorption", "Diffraction"], 0,
          "Exceeding critical angle reflects 100% of incident light back into denser medium; utilized in optical fibers and sparkling diamonds.", 1, "Medium", "Total Internal Reflection")
    add_q("C9_T3_5", 9, "Light – Reflection and Refraction", "Speed of Light in Different Media", "TEST_3", "CASE_BASED",
          "Refractive indices of water, crown glass, and flint glass are 1.33, 1.52, and 1.65 respectively. In which medium does light travel fastest?",
          ["Water (lowest refractive index)", "Crown glass", "Flint glass", "Speed is same in all"], 0,
          "v = c / n. Lower refractive index means higher propagation speed: v_water = 2.25 x 10^8 m/s.", 1, "Medium", "Speed Comparison")
    add_q("C9_T3_6", 9, "Light – Reflection and Refraction", "Cartesian Object Distance Sign", "TEST_3", "CASE_BASED",
          "In Cartesian sign convention, why is the object distance (u) always assigned a negative value for both mirrors and lenses?",
          ["The object is conventionally placed to the left of the optical center / pole, in the negative x-direction", "Light travels backwards", "Objects have negative mass", "Images are always real"], 0,
          "Distances measured against the direction of incident light (left of origin) are strictly negative.", 1, "Easy", "Cartesian Conventions")

    # REVISION (6)
    add_q("C9_REV_1", 9, "Light – Reflection and Refraction", "Quick Recall - Dioptre Definition", "REVISION", "MCQ",
          "1 Dioptre (1 D) is defined as the optical power of a lens whose focal length is:",
          ["1 metre", "100 metres", "1 centimetre", "10 centimetres"], 0,
          "1 D = 1 m^-1. Power is reciprocal of focal length expressed in metres.", 1, "Easy", "Rapid Recall")
    add_q("C9_REV_2", 9, "Light – Reflection and Refraction", "Quick Recall - Plane Mirror Magnification", "REVISION", "MCQ",
          "The magnification produced by a common household plane mirror is always exactly:",
          ["+1", "-1", "0", "Infinity"], 0,
          "m = +1 indicates image is virtual, erect, and identical in height to object (h' = h).", 1, "Easy", "Plane Mirror Recall")
    add_q("C9_REV_3", 9, "Light – Reflection and Refraction", "Quick Recall - Concave Lens Divergence", "REVISION", "MCQ",
          "A concave lens is also known as a ______ lens, while a convex lens is known as a ______ lens.",
          ["Diverging; Converging", "Converging; Diverging", "Bifocal; Cylindrical", "Parabolic; Plane"], 0,
          "Concave diverges parallel rays outwards; convex converges parallel rays to a focal point.", 1, "Easy", "Terminology")
    add_q("C9_REV_4", 9, "Light – Reflection and Refraction", "Quick Recall - Focal Length of Plane Mirror", "REVISION", "MCQ",
          "The focal length and radius of curvature of a perfectly flat plane mirror are:",
          ["Infinity", "Zero", "1 metre", "-1 metre"], 0,
          "A flat plane has zero curvature, giving an infinite radius and focal length.", 1, "Easy", "Geometric Fact")
    add_q("C9_REV_5", 9, "Light – Reflection and Refraction", "Quick Recall - Real Image Nature", "REVISION", "MCQ",
          "Which characteristic is true for all real images formed by spherical mirrors or lenses?",
          ["They can be projected onto a physical screen and are always inverted relative to object", "They are always erect", "They cannot be touched", "They only form in darkness"], 0,
          "Real images result from actual physical convergence of light rays and can be captured on screens.", 1, "Easy", "Image Types")
    add_q("C9_REV_6", 9, "Light – Reflection and Refraction", "Quick Recall - Optically Denser vs Mass Denser", "REVISION", "MCQ",
          "Kerosene has higher refractive index (n = 1.44) than water (n = 1.33) but lower mass density (floats on water). This shows that:",
          ["Optical density depends on speed of light in medium and is not the same as physical mass density", "Water is a solid", "Kerosene bends light less", "Light travels faster in kerosene"], 0,
          "Optical density is an electromagnetic refractive property distinct from volumetric mass density.", 1, "Medium", "Optical Physics")

    # ==========================================
    # CHAPTER 10: The Human Eye and the Colourful World (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C10_P_1", 10, "The Human Eye and the Colourful World", "Myopia Correction", "PRACTICE", "MCQ",
          "A student cannot clearly see letters on the blackboard 5 meters away, but reads his book easily. He has ______ and requires a ______ lens.",
          ["Myopia (near-sightedness); Concave (diverging)", "Hypermetropia; Convex", "Presbyopia; Cylindrical", "Cataract; Bifocal"], 0,
          "Myopic eyeball is elongated; image forms in front of retina. A concave lens diverges rays to focus sharply onto retina.", 1, "Easy", "Defects of Vision")
    add_q("C10_P_2", 10, "The Human Eye and the Colourful World", "Twinkling of Stars", "PRACTICE", "MCQ",
          "The twinkling of stars at night and advance sunrise by ~2 minutes are caused by:",
          ["Atmospheric refraction of starlight through turbulent air layers of varying optical densities", "Internal reflection within clouds", "Tyndall scattering by ozone", "Diffraction"], 0,
          "Continuous fluctuations in atmospheric temperature and refractive index shift starlight rays, modulating apparent brightness.", 1, "Easy", "Atmospheric Refraction")
    add_q("C10_P_3", 10, "The Human Eye and the Colourful World", "Prism Dispersion Deviation", "PRACTICE", "MCQ",
          "When white light passes through a triangular glass prism, which colour bends (deviates) the MOST and which the LEAST?",
          ["Most: Violet; Least: Red", "Most: Red; Least: Violet", "Most: Yellow; Least: Green", "All colours deviate identically"], 0,
          "Violet has the shortest wavelength in visible spectrum and highest refractive index in glass, bending the most.", 1, "Medium", "Dispersion Spectrum")
    add_q("C10_P_4", 10, "The Human Eye and the Colourful World", "Danger Signal Lights Red", "PRACTICE", "MCQ",
          "Danger signal lights on towers and traffic intersections are always red in colour because:",
          ["Red light has the longest wavelength and is scattered least by smoke and fog", "Red light is reflected by air", "Human eyes are blind to blue", "Red light travels at double speed"], 0,
          "By Rayleigh scattering law (I proportional to 1/lambda^4), red light scatters least and penetrates maximum distance.", 1, "Easy", "Scattering Applications")
    add_q("C10_P_5", 10, "The Human Eye and the Colourful World", "Power of Accommodation", "PRACTICE", "MCQ",
          "The ability of the eye crystalline lens to adjust its focal length to view both near and distant objects is called:",
          ["Power of Accommodation (controlled by ciliary muscles)", "Persistence of vision", "Visual acuity", "Depth perception"], 0,
          "Ciliary muscles contract (thickening lens for near vision) or relax (thinning lens for distant vision).", 1, "Easy", "Visual Physiology")
    add_q("C10_P_6", 10, "The Human Eye and the Colourful World", "Near Point of Normal Eye", "PRACTICE", "MCQ",
          "The least distance of distinct vision (near point) for a healthy young adult human eye is approximately:",
          ["25 cm", "2.5 cm", "10 cm", "Infinity"], 0,
          "Objects closer than 25 cm cannot be focused sharply without muscular strain.", 1, "Easy", "Physiological Standard")

    # TEST_1 (6)
    add_q("C10_T1_1", 10, "The Human Eye and the Colourful World", "Hypermetropia Correction", "TEST_1", "MCQ",
          "An elderly person can see distant mountains clearly but cannot read newspaper print without reading glasses. This defect is:",
          ["Hypermetropia (far-sightedness); corrected by convex lens", "Myopia; corrected by concave lens", "Astigmatism", "Glaucoma"], 0,
          "Hypermetropic eyeball is too short; near rays focus behind retina. Converging convex lens provides extra convergence.", 1, "Medium", "Defect Diagnosis")
    add_q("C10_T1_2", 10, "The Human Eye and the Colourful World", "Presbyopia Bifocal Lenses", "TEST_1", "MCQ",
          "Presbyopia occurs due to gradual weakening of ciliary muscles and diminishing flexibility of eye lens with age. It is corrected by bifocal lenses where:",
          ["Upper part is concave (for distant vision) and lower part is convex (for reading)", "Upper is convex and lower is concave", "Both parts are cylindrical", "Only tinted glass is used"], 0,
          "Upper diverging portion facilitates distant gaze; lower converging portion facilitates downward reading gaze.", 1, "Medium", "Optical Correction")
    add_q("C10_T1_3", 10, "The Human Eye and the Colourful World", "Rainbow Formation Three Steps", "TEST_1", "MCQ",
          "A natural rainbow is formed in the sky opposite to sun by raindrops through the sequential physical phenomena of:",
          ["Refraction -> Dispersion -> Total Internal Reflection -> Refraction", "Reflection -> Absorption -> Scattering", "Diffraction -> Interference", "Polarisation only"], 0,
          "Sunlight enters raindrop (refraction/dispersion), internally reflects off back wall, and refracts out into viewer's eye.", 1, "Hard", "Rainbow Physics")
    add_q("C10_T1_4", 10, "The Human Eye and the Colourful World", "Tyndall Effect in Forest", "TEST_1", "MCQ",
          "Sunlight streaming through a dense forest canopy reveals visible luminous beam pathways due to scattering of light by mist droplets. This is:",
          ["Tyndall Effect", "Photoelectric Effect", "Compton Scattering", "Zeeman Effect"], 0,
          "Colloidal smoke, dust, and water droplets scatter light sideways, illuminating the beam path.", 1, "Easy", "Colloidal Optics")
    add_q("C10_T1_5", 10, "The Human Eye and the Colourful World", "Blue Sky Cause", "TEST_1", "MCQ",
          "The clear sky appears deep blue during the day because fine gas molecules (N2, O2) in the atmosphere:",
          ["Scatter blue light of shorter wavelength much more strongly than red light", "Absorb blue light", "Emit blue photons", "Reflect ocean water"], 0,
          "Rayleigh scattering: nitrogen and oxygen molecules (smaller than light wavelength) scatter blue 16 times more than red.", 1, "Easy", "Sky Color")
    add_q("C10_T1_6", 10, "The Human Eye and the Colourful World", "Sky Appearance in Space", "TEST_1", "MCQ",
          "To an astronaut orbiting in outer space or on the Moon, the sky appears completely dark/black because:",
          ["There is no atmosphere to scatter sunlight into the observer's eyes", "Space absorbs all light", "Sun does not shine in space", "Stars block vision"], 0,
          "Without gas molecules or aerosols, scattering does not occur; space appears pitch black even with bright sun visible.", 1, "Easy", "Space Physics")

    # TEST_2 (6)
    add_q("C10_T2_1", 10, "The Human Eye and the Colourful World", "Recombination of Spectrum", "TEST_2", "COMPETENCY_BASED",
          "Isaac Newton demonstrated that white light is composed of 7 colours by placing two identical glass prisms such that:",
          ["The second prism is inverted with respect to the first, recombining the 7 spectrum colours back into white light", "Both prisms point upwards", "Prisms are filled with water", "A red filter is inserted"], 0,
          "First prism disperses white light; identical inverted prism bends colours inversely, recombining them into parallel white beam.", 1, "Hard", "Newton Experiment")
    add_q("C10_T2_2", 10, "The Human Eye and the Colourful World", "Apparent Sunrise Delayed Sunset Duration", "TEST_2", "COMPETENCY_BASED",
          "The sun is visible to us about 2 minutes before actual sunrise and remains visible 2 minutes after actual sunset due to atmospheric refraction. Total apparent day length increases by:",
          ["4 minutes", "2 minutes", "10 minutes", "1 minute"], 0,
          "2 minutes advance sunrise + 2 minutes delayed sunset = 4 minutes total extension of daylight hours.", 1, "Medium", "Atmospheric Timing")
    add_q("C10_T2_3", 10, "The Human Eye and the Colourful World", "Reddish Sun at Horizon", "TEST_2", "COMPETENCY_BASED",
          "At sunrise and sunset, the sun appears deep red and flattened, whereas at noon overhead it appears white because:",
          ["At horizon, sunlight traverses a much thicker atmospheric path; blue light is scattered away, leaving long red wavelengths to reach eyes", "Sun is cooler at sunset", "Sun burns coal", "Noon light is green"], 0,
          "Light travels maximum distance through atmosphere at horizon; shorter blue/violet wavelengths scatter out of sight.", 1, "Medium", "Horizon Optics")
    add_q("C10_T2_4", 10, "The Human Eye and the Colourful World", "Pupil and Iris Function", "TEST_2", "COMPETENCY_BASED",
          "When entering a dim movie theatre from bright daylight, we cannot see clearly for a few moments until:",
          ["The iris dilates the pupil opening, allowing more light to enter the eye", "Retina changes color", "Cornea flattens", "Eye lens turns blue"], 0,
          "Iris muscles reflexively regulate pupil diameter: constricting in bright light to protect retina, dilating in dim light.", 1, "Easy", "Pupillary Reflex")
    add_q("C10_T2_5", 10, "The Human Eye and the Colourful World", "Cataract and Treatment", "TEST_2", "COMPETENCY_BASED",
          "In older adults, the crystalline eye lens sometimes becomes milky, cloudy, and opaque leading to partial or complete loss of vision. This condition is:",
          ["Cataract (treated by surgical intraocular lens replacement)", "Myopia", "Glaucoma", "Trachoma"], 0,
          "Protein aggregation clouds the lens; modern phacoemulsification surgery restores vision with artificial IOL implants.", 1, "Easy", "Eye Pathology")
    add_q("C10_T2_6", 10, "The Human Eye and the Colourful World", "Retina Rods and Cones", "TEST_2", "COMPETENCY_BASED",
          "The light-sensitive retina contains two types of photoreceptor cells: rods and cones. Their respective functions are:",
          ["Rods: vision in dim twilight light; Cones: color perception in bright daylight", "Rods: color; Cones: dim light", "Rods: focus; Cones: pupil movement", "Both detect only infrared"], 0,
          "Rods contain rhodopsin for scotopic night vision; cones contain photopsins for photopic trichromatic color vision.", 1, "Medium", "Retinal Cytology")

    # TEST_3 (6)
    add_q("C10_T3_1", 10, "The Human Eye and the Colourful World", "Assertion on Stars vs Planets Twinkling", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): Distant stars twinkle at night, but nearby planets do not twinkle.\nReason (R): Planets are much closer to Earth and act as extended disc sources of light; shifting fluctuations from different points average out to zero net change.",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "Stars are point sources whose single ray wavers; extended planetary discs average across millions of rays, nullifying twinkling.", 1, "Medium", "Board Pattern A/R")
    add_q("C10_T3_2", 10, "The Human Eye and the Colourful World", "Flickering Above Bonfire", "TEST_3", "CASE_BASED",
          "Objects seen through hot air rising above a campfire appear to waver and flicker. This is due to:",
          ["Random fluctuations in refractive index of air as hot air expands and rises irregularly", "Smoke absorbing light", "Carbon burning in eyes", "Sound vibrations"], 0,
          "Hot air is optically rarer than cold air above it; turbulence constantly shifts the apparent position of background objects.", 1, "Medium", "Thermal Refraction")
    add_q("C10_T3_3", 10, "The Human Eye and the Colourful World", "Angle of Deviation in Prism", "TEST_3", "CASE_BASED",
          "In refraction through a glass prism, the angle between the incident ray produced forward and emergent ray produced backward is called:",
          ["Angle of Deviation (D)", "Angle of Emergence", "Critical Angle", "Angle of Reflection"], 0,
          "Angle of deviation represents total angular turn light undergoes passing through non-parallel prism faces.", 1, "Easy", "Prism Geometry")
    add_q("C10_T3_4", 10, "The Human Eye and the Colourful World", "Cornea Function", "TEST_3", "CASE_BASED",
          "Most of the optical refraction of light entering the human eye occurs at the:",
          ["Outer convex surface of the transparent cornea", "Crystalline eye lens", "Retina", "Vitreous humor"], 0,
          "The air-cornea interface provides roughly 40 to 45 dioptres (over 70%) of the eye's total refractive power.", 1, "Medium", "Ocular Refraction")
    add_q("C10_T3_5", 10, "The Human Eye and the Colourful World", "Persistence of Vision", "TEST_3", "CASE_BASED",
          "An optical image persists on the human retina for approximately 1/16th of a second after light is removed. This phenomenon enables:",
          ["Cinematography (motion pictures projected at 24 frames/sec)", "Eye accommodation", "Color vision", "Pupil constriction"], 0,
          "Rapid presentation of stationary images blending into continuous motion relies on persistence of vision.", 1, "Easy", "Vision Mechanics")
    add_q("C10_T3_6", 10, "The Human Eye and the Colourful World", "Why Two Eyes", "TEST_3", "CASE_BASED",
          "Having two eyes positioned in front of our face provides a horizontal field of view of about 180 degrees and is essential for:",
          ["Stereoscopic 3D vision and accurate depth perception", "Seeing in complete darkness", "Filtering UV rays", "Sleeping with one eye open"], 0,
          "Binocular disparity combines two slightly different retinal angles in the brain to perceive 3D relief and distance.", 1, "Medium", "Binocular Vision")

    # REVISION (6)
    add_q("C10_REV_1", 10, "The Human Eye and the Colourful World", "Quick Recall - Far Point of Eye", "REVISION", "MCQ",
          "The far point of a normal human eye without corrective glasses is:",
          ["Infinity", "25 cm", "100 metres", "2 km"], 0,
          "A relaxed normal eye focuses parallel rays from infinity onto the retina.", 1, "Easy", "Rapid Recall")
    add_q("C10_REV_2", 10, "The Human Eye and the Colourful World", "Quick Recall - VIBGYOR Acronym", "REVISION", "MCQ",
          "In the visible light spectrum, the correct sequence of colours from longest wavelength to shortest wavelength is:",
          ["Red, Orange, Yellow, Green, Blue, Indigo, Violet", "Violet, Indigo, Blue, Green, Yellow, Orange, Red", "Green, Yellow, Red, Blue", "Blue, Red, Violet"], 0,
          "Red has the longest wavelength (~700 nm); violet has the shortest visible wavelength (~400 nm).", 1, "Easy", "Spectrum Order")
    add_q("C10_REV_3", 10, "The Human Eye and the Colourful World", "Quick Recall - Blind Spot", "REVISION", "MCQ",
          "The point on the retina where the optic nerve leaves the eyeball and lacks photoreceptor rods and cones is the:",
          ["Blind spot", "Yellow spot (Fovea centralis)", "Cornea", "Pupil"], 0,
          "No image can be perceived at the optic disc (blind spot) due to absence of photoreceptors.", 1, "Easy", "Anatomy Recall")
    add_q("C10_REV_4", 10, "The Human Eye and the Colourful World", "Quick Recall - Ciliary Muscle Relaxation", "REVISION", "MCQ",
          "When looking at distant stars or mountains, the ciliary muscles ______ and the eye lens becomes ______.",
          ["Relax; Thin (increasing focal length)", "Contract; Thick", "Vibrate; Flat", "Twist; Opaque"], 0,
          "Relaxed ciliary muscles stretch suspensory ligaments, flattening the crystalline lens for distant focus.", 1, "Medium", "Accommodation Recall")
    add_q("C10_REV_5", 10, "The Human Eye and the Colourful World", "Quick Recall - Eye Donation Part", "REVISION", "MCQ",
          "During corneal transplant (eye donation), which transparent front tissue of donor eye is transplanted?",
          ["Cornea", "Retina", "Optic nerve", "Entire eyeball with brain"], 0,
          "Only the avascular clear corneal button is excised and grafted onto recipient eye.", 1, "Easy", "Medical Science")
    add_q("C10_REV_6", 10, "The Human Eye and the Colourful World", "Quick Recall - Liquid in Anterior Chamber", "REVISION", "MCQ",
          "The watery fluid filling space between cornea and crystalline lens is ______ while gelatinous fluid between lens and retina is ______.",
          ["Aqueous humor; Vitreous humor", "Vitreous humor; Aqueous humor", "Blood plasma; Lymph", "Mucus; Saliva"], 0,
          "Aqueous humor maintains anterior chamber pressure; vitreous body maintains spherical eyeball shape.", 1, "Easy", "Eye Anatomy")

    # ==========================================
    # CHAPTER 11: Electricity (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C11_P_1", 11, "Electricity", "Ohm's Law Definition", "PRACTICE", "MCQ",
          "According to Ohm's Law, at constant temperature, the electric current (I) flowing through a metallic conductor is:",
          ["Directly proportional to the potential difference (V) across its ends (V = I * R)", "Inversely proportional to voltage", "Proportional to V^2", "Independent of voltage"], 0,
          "V = IR. The constant of proportionality R is electrical resistance of conductor.", 1, "Easy", "Ohm's Law")
    add_q("C11_P_2", 11, "Electricity", "Equivalent Resistance in Parallel", "PRACTICE", "MCQ",
          "Three resistors of resistances 2 Ohm, 3 Ohm, and 6 Ohm are connected in parallel. Their equivalent resistance is:",
          ["1 Ohm", "11 Ohm", "0.5 Ohm", "3 Ohm"], 0,
          "1/Req = 1/2 + 1/3 + 1/6 = 3/6 + 2/6 + 1/6 = 6/6 = 1 => Req = 1 Ohm.", 1, "Medium", "Parallel Circuit Calculation")
    add_q("C11_P_3", 11, "Electricity", "Wire Stretching Resistance", "PRACTICE", "MCQ",
          "A metallic wire of resistance R is stretched so that its length doubles (2L) while volume remains constant. Its new resistance is:",
          ["4 R", "2 R", "R / 2", "R / 4"], 0,
          "Volume V = A * L is constant. Doubling length halves cross-sectional area (A/2). R' = rho*(2L)/(A/2) = 4*(rho*L/A) = 4R.", 1, "Hard", "Resistivity Physics")
    add_q("C11_P_4", 11, "Electricity", "Commercial Energy Unit Calculation", "PRACTICE", "MCQ",
          "An electric geyser rated 2000 W (2 kW) runs for 3 hours daily. How many units (kWh) of electrical energy does it consume in 30 days?",
          ["180 units (kWh)", "60 units", "300 units", "6 units"], 0,
          "Daily energy = 2 kW * 3 h = 6 kWh. In 30 days = 6 * 30 = 180 kWh (units).", 1, "Medium", "Commercial Calculation")
    add_q("C11_P_5", 11, "Electricity", "Fuse Wire Properties", "PRACTICE", "MCQ",
          "An electric safety fuse wire must possess which physical characteristics?",
          ["High resistance and Low melting point (e.g. Lead-Tin alloy)", "Low resistance and High melting point", "Zero resistance and High melting point", "Thick copper strip"], 0,
          "Excess current produces Joule heat (I^2*R) rapidly melting the low-melting-point fuse wire, interrupting fire hazard.", 1, "Easy", "Electrical Safety")
    add_q("C11_P_6", 11, "Electricity", "Unit of Electric Potential", "PRACTICE", "MCQ",
          "One Volt (1 V) of electric potential difference is defined as:",
          ["1 Joule of work done in moving 1 Coulomb of electric charge (1 V = 1 J / 1 C)", "1 Ampere per second", "1 Ohm per metre", "1 Watt per hour"], 0,
          "V = W / Q. 1 Volt = 1 Joule / 1 Coulomb.", 1, "Easy", "Units")

    # TEST_1 (6)
    add_q("C11_T1_1", 11, "Electricity", "Factors Affecting Resistance", "TEST_1", "MCQ",
          "The electrical resistance of a uniform metallic cylindrical conductor depends on all the following EXCEPT:",
          ["Applied potential difference", "Length of conductor (R directly proportional to L)", "Area of cross-section (R inversely proportional to A)", "Nature of material (resistivity rho) and temperature"], 0,
          "Resistance is an intrinsic geometric/material property; it does not change with applied voltage (Ohm's Law).", 1, "Medium", "Resistivity Concepts")
    add_q("C11_T1_2", 11, "Electricity", "Resistivity SI Unit", "TEST_1", "MCQ",
          "The SI unit of electrical resistivity (rho) is:",
          ["Ohm-metre (Ohm.m)", "Ohm / metre", "Ohm / second", "Volt / Ampere"], 0,
          "rho = R * A / L = (Ohm * m^2) / m = Ohm.m.", 1, "Easy", "Units and Measurements")
    add_q("C11_T1_3", 11, "Electricity", "Joule's Law of Heating Formula", "TEST_1", "MCQ",
          "According to Joule's Law of Heating, heat produced (H) in a resistor of resistance R carrying current I for time t is:",
          ["H = I^2 * R * t", "H = I * R * t", "H = I^2 * t / R", "H = V * I / t"], 0,
          "H = VIt = I^2*Rt = (V^2/R)*t in Joules.", 1, "Easy", "Joule Heating")
    add_q("C11_T1_4", 11, "Electricity", "Electric Bulb Filament Tungsten", "TEST_1", "MCQ",
          "Tungsten metal is almost exclusively used for incandescent lamp filaments because it has:",
          ["Very high melting point (3380°C) and glows white-hot without melting", "Zero resistance", "Low boiling point", "Highest conductivity of all metals"], 0,
          "Tungsten survives radiant white incandescence without subliming or melting.", 1, "Easy", "Materials Science")
    add_q("C11_T1_5", 11, "Electricity", "Inert Gas in Electric Bulbs", "TEST_1", "MCQ",
          "Electric incandescent bulbs are filled with chemically inactive gases like Argon and Nitrogen to:",
          ["Prolong the life of the hot tungsten filament by preventing oxidation", "Make bulb glow blue", "Cool down the glass", "Conduct electricity through air"], 0,
          "Argon/nitrogen suppresses tungsten evaporation and prevents oxidation combustion.", 1, "Easy", "Bulb Chemistry")
    add_q("C11_T1_6", 11, "Electricity", "Ammeter vs Voltmeter Connection", "TEST_1", "MCQ",
          "In an electric circuit, an Ammeter is connected in ______ and a Voltmeter in ______.",
          ["Series (has very low resistance); Parallel (has very high resistance)", "Parallel; Series", "Both in series", "Both in parallel"], 0,
          "Ammeter measures total branch current in series; high-resistance voltmeter measures voltage across components without drawing current.", 1, "Medium", "Circuit Instruments")

    # TEST_2 (6)
    add_q("C11_T2_1", 11, "Electricity", "Series vs Parallel Domestic Wiring", "TEST_2", "COMPETENCY_BASED",
          "Why is parallel arrangement used for domestic domestic wiring rather than series arrangement?",
          ["Each appliance gets full 220V supply and can be switched independently; failure of one does not break other circuits", "Parallel uses less wire", "Parallel gives zero current", "Appliances glow yellow in parallel"], 0,
          "In series, if one bulb blows, the whole circuit opens, and voltage divides among appliances.", 1, "Medium", "Domestic Circuit Analysis")
    add_q("C11_T2_2", 11, "Electricity", "Heating Element Nichrome Alloy", "TEST_2", "COMPETENCY_BASED",
          "Heating elements of electric toasters and irons are made of alloys (like Nichrome) rather than pure metals because alloys:",
          ["Have higher resistivity and do not oxidize (burn) easily at high red-hot temperatures", "Have lower melting points", "Cost less than iron", "Are transparent"], 0,
          "Nichrome (Ni-Cr-Mn-Fe) has ~60x resistivity of copper and forms a protective non-oxidizing skin at 1000°C.", 1, "Medium", "Alloy Resistivity")
    add_q("C11_T2_3", 11, "Electricity", "V-I Graph Slope Meaning", "TEST_2", "COMPETENCY_BASED",
          "In a plot of Potential Difference (V) on y-axis versus Electric Current (I) on x-axis for an ohmic conductor, the slope of the straight line equals:",
          ["Resistance (R = V / I)", "Resistivity (rho)", "Electric Power (P)", "Heat energy"], 0,
          "Slope = delta V / delta I = R in Ohms.", 1, "Easy", "Graphical Analysis")
    add_q("C11_T2_4", 11, "Electricity", "Current in Closed Circuit with Electrons", "TEST_2", "COMPETENCY_BASED",
          "If electric current flows from positive terminal to negative terminal conventionally, in which direction do conduction electrons drift in the metallic wire?",
          ["From negative terminal to positive terminal (opposite to conventional current)", "In the same direction as current", "Radial to wire", "Electrons stay stationary"], 0,
          "Negatively charged electrons are repelled by negative terminal and drift towards positive terminal.", 1, "Easy", "Drift Velocity Concept")
    add_q("C11_T2_5", 11, "Electricity", "Power Dissipation in Two Resistors", "TEST_2", "COMPETENCY_BASED",
          "Two electric bulbs rated 40 W, 220 V and 100 W, 220 V are connected in series across a 220 V supply. Which bulb will glow brighter?",
          ["The 40 W bulb (it has higher resistance, so P = I^2*R is greater in series)", "The 100 W bulb", "Both glow with equal brightness", "Neither bulb glows"], 0,
          "R = V^2 / P => R_40 = 1210 Ohm, R_100 = 484 Ohm. In series, same current I flows; 40W bulb dissipates more heat (I^2*R) and glows brighter.", 1, "Hard", "High-Order Thinking")
    add_q("C11_T2_6", 11, "Electricity", "Commercial 1 kWh in Joules", "TEST_2", "COMPETENCY_BASED",
          "One commercial unit of electrical energy (1 kilowatt-hour) equals how many Joules in SI units?",
          ["3.6 x 10^6 Joules (3.6 MJ)", "3.6 x 10^3 Joules", "1000 Joules", "60 Joules"], 0,
          "1 kWh = 1000 W * 3600 seconds = 3,600,000 Joules = 3.6 x 10^6 J.", 1, "Easy", "Unit Conversion")

    # TEST_3 (6)
    add_q("C11_T3_1", 11, "Electricity", "Assertion on Thicker Wire Resistance", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): A thick copper wire has lower electrical resistance than a thin copper wire of the same length.\nReason (R): Resistance of a conductor is inversely proportional to its cross-sectional area (R proportional to 1/A).",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "Larger cross-sectional area offers more parallel conduction channels for electron drift, reducing resistance.", 1, "Medium", "Board Pattern A/R")
    add_q("C11_T3_2", 11, "Electricity", "Number of Electrons in 1 Coulomb", "TEST_3", "CASE_BASED",
          "If the elementary charge on one electron is e = 1.6 x 10^-19 C, how many electrons constitute 1 Coulomb of negative charge?",
          ["6.25 x 10^18 electrons", "1.6 x 10^19 electrons", "6.022 x 10^23 electrons", "10^6 electrons"], 0,
          "n = Q / e = 1 / (1.6 x 10^-19) = 6.25 x 10^18 electrons.", 1, "Medium", "Charge Quantization")
    add_q("C11_T3_3", 11, "Electricity", "Short Circuit Current Surge", "TEST_3", "CASE_BASED",
          "During an accidental short-circuit when live wire touches neutral wire directly, the electric current in the circuit:",
          ["Increases enormously due to near-zero resistance", "Decreases to zero", "Does not change", "Fluctuates at 50 Hz only"], 0,
          "Zero resistance fault path causes massive current spike, creating extreme Joule heating and fire risk unless fuse trips.", 1, "Medium", "Circuit Faults")
    add_q("C11_T3_4", 11, "Electricity", "Series Combination Voltage Division", "TEST_3", "CASE_BASED",
          "Three resistors of 5 Ohm, 10 Ohm, and 15 Ohm are connected in series across a 12 V battery. What is the potential difference across the 15 Ohm resistor?",
          ["6.0 Volts", "2.0 Volts", "4.0 Volts", "12.0 Volts"], 0,
          "R_total = 5 + 10 + 15 = 30 Ohm. I = V / R = 12 / 30 = 0.4 A. V_15 = I * R = 0.4 * 15 = 6.0 V.", 1, "Medium", "Circuit Numerical")
    add_q("C11_T3_5", 11, "Electricity", "Electric Power Formula Variations", "TEST_3", "CASE_BASED",
          "Which of the following expressions does NOT represent electrical power dissipated in a circuit?",
          ["I * R^2", "V * I", "I^2 * R", "V^2 / R"], 0,
          "Power formulas are P = VI = I^2*R = V^2/R. I*R^2 has dimensions of volt-metres, not power.", 1, "Medium", "Formula Identification")
    add_q("C11_T3_6", 11, "Electricity", "Superconductors Zero Resistance", "TEST_3", "CASE_BASED",
          "Certain materials lose all electrical resistance completely below a critical transition temperature. These materials are known as:",
          ["Superconductors", "Semiconductors", "Dielectrics", "Electrolytes"], 0,
          "Zero DC resistance in superconducting state allows persistent electric currents without energy dissipation.", 1, "Easy", "Advanced Physics")

    # REVISION (6)
    add_q("C11_REV_1", 11, "Electricity", "Quick Recall - Electric Current Definition", "REVISION", "MCQ",
          "Electric current is quantitatively defined as the rate of flow of electric charge across a cross section: I = Q / t. Its SI unit is:",
          ["Ampere (A)", "Volt (V)", "Coulomb (C)", "Ohm"], 0,
          "1 Ampere = 1 Coulomb per second.", 1, "Easy", "Rapid Recall")
    add_q("C11_REV_2", 11, "Electricity", "Quick Recall - Rheostat Device", "REVISION", "MCQ",
          "An electrical component used in laboratory circuits to regulate electric current without changing voltage source is a:",
          ["Rheostat (Variable resistor)", "Galvanometer", "Voltmeter", "Capacitor"], 0,
          "A sliding contact rheostat varies circuit resistance to control current intensity.", 1, "Easy", "Laboratory Apparatus")
    add_q("C11_REV_3", 11, "Electricity", "Quick Recall - Earth Wire Safety", "REVISION", "MCQ",
          "The green earth wire connected to metallic casing of appliances (electric iron, refrigerator) protects users by:",
          ["Providing a low-resistance path to ground for leakage currents, blowing fuse and preventing lethal shock", "Supplying power to motor", "Reducing electricity bill", "Increasing appliance speed"], 0,
          "Earthing keeps metallic casing at ground potential (0V), ensuring user safety during insulation failure.", 1, "Easy", "Safety Systems")
    add_q("C11_REV_4", 11, "Electricity", "Quick Recall - Copper and Aluminium for Transmission", "REVISION", "MCQ",
          "Copper and Aluminium metals are universally chosen for overhead electric transmission lines because they possess:",
          ["Very low electrical resistivity and high conductivity", "High resistance", "Low melting points", "Magnetic attraction"], 0,
          "Low resistivity minimizes Joule heat transmission losses (I^2*R) over long grid distances.", 1, "Easy", "Transmission Material")
    add_q("C11_REV_5", 11, "Electricity", "Quick Recall - Resistance of Wire Cut in Half", "REVISION", "MCQ",
          "A uniform wire of resistance 20 Ohm is cut into two equal halves. The resistance of each piece is:",
          ["10 Ohm", "40 Ohm", "5 Ohm", "20 Ohm"], 0,
          "Resistance is proportional to length (R proportional to L); halving length halves resistance to 10 Ohm.", 1, "Easy", "Simple Proportionality")
    add_q("C11_REV_6", 11, "Electricity", "Quick Recall - Resistors in Parallel Cut", "REVISION", "MCQ",
          "If the two 10 Ohm pieces from the previous question are connected in parallel, their combined resistance is:",
          ["5 Ohm", "20 Ohm", "10 Ohm", "2.5 Ohm"], 0,
          "1/Req = 1/10 + 1/10 = 2/10 = 1/5 => Req = 5 Ohm.", 1, "Easy", "Parallel Arithmetic")

    # ==========================================
    # CHAPTER 12: Magnetic Effects of Electric Current (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C12_P_1", 12, "Magnetic Effects of Electric Current", "Field Lines Properties", "PRACTICE", "MCQ",
          "Which of the following is an INCORRECT statement regarding magnetic field lines around a bar magnet?",
          ["Field lines intersect each other near the poles where the field is strongest", "They emerge from North pole and enter South pole outside magnet", "Inside the magnet, lines run from South to North", "They form closed continuous loops"], 0,
          "Field lines never intersect. If they intersected, a compass needle placed at the intersection point would point in two directions simultaneously, which is impossible.", 1, "Easy", "Field Line Properties")
    add_q("C12_P_2", 12, "Magnetic Effects of Electric Current", "Right-Hand Thumb Rule", "PRACTICE", "MCQ",
          "If electric current in a vertical straight conductor flows upwards, the direction of magnetic field lines viewed from above is:",
          ["Anticlockwise concentric circles", "Clockwise concentric circles", "Linear towards North", "Radial outward"], 0,
          "Maxwell's Right-Hand Thumb Rule: Point right thumb upwards in direction of current; curled fingers point anticlockwise.", 1, "Medium", "Rule Application")
    add_q("C12_P_3", 12, "Magnetic Effects of Electric Current", "Fleming's Left-Hand Rule", "PRACTICE", "MCQ",
          "According to Fleming's Left-Hand Rule used for electric motors, what do the Forefinger, Central finger, and Thumb indicate respectively?",
          ["Forefinger: Magnetic Field; Central finger: Current; Thumb: Motion / Force", "Forefinger: Current; Central finger: Field; Thumb: Force", "Forefinger: Force; Central finger: Current; Thumb: Field", "Forefinger: Potential; Central finger: Current; Thumb: Resistance"], 0,
          "FBI mnemonic: Thumb = Force/Motion, Forefinger = magnetic Field, Central finger = Current.", 1, "Medium", "Rule Demonstration")
    add_q("C12_P_4", 12, "Magnetic Effects of Electric Current", "Magnetic Field in Solenoid", "PRACTICE", "MCQ",
          "The magnetic field inside a long straight current-carrying solenoid is:",
          ["Uniform and same at all points inside", "Zero at the centre", "Decreases towards ends", "Circular inside"], 0,
          "Parallel straight equidistant field lines inside a solenoid indicate a uniform magnetic field.", 1, "Medium", "Solenoid Field")
    add_q("C12_P_5", 12, "Magnetic Effects of Electric Current", "Domestic AC Supply India", "PRACTICE", "MCQ",
          "The domestic alternating current (AC) power supplied to homes in India has a potential difference and frequency of:",
          ["220 V and 50 Hz", "110 V and 60 Hz", "220 V and 100 Hz", "440 V and 50 Hz"], 0,
          "In India, domestic AC is supplied at 220 Volts with 50 Hz frequency (reversing polarity 100 times per second).", 1, "Easy", "Standard Values")
    add_q("C12_P_6", 12, "Magnetic Effects of Electric Current", "Soft Iron Core in Electromagnet", "PRACTICE", "MCQ",
          "An electromagnet is constructed by inserting a soft iron core into a current-carrying solenoid because soft iron:",
          ["Has high magnetic permeability, strongly multiplying magnetic field and losing magnetism when current is switched off", "Retains permanent magnetism forever", "Does not conduct electricity", "Is made of copper"], 0,
          "Soft iron magnetizes rapidly and demagnetizes immediately when current ceases, creating a versatile temporary magnet.", 1, "Medium", "Electromagnetism")

    # TEST_1 (6)
    add_q("C12_T1_1", 12, "Magnetic Effects of Electric Current", "Oersted Experiment", "TEST_1", "MCQ",
          "In 1820, Hans Christian Oersted discovered the magnetic effect of electric current by noticing that:",
          ["A magnetic compass needle deflected when placed near a current-carrying wire", "Copper attracts iron", "Magnets generate light", "Electric current produces water"], 0,
          "Oersted showed for the first time that moving electric charges create an encircling magnetic field.", 1, "Easy", "Historical Discovery")
    add_q("C12_T1_2", 12, "Magnetic Effects of Electric Current", "Electric Motor Energy Conversion", "TEST_1", "MCQ",
          "An electric motor is a rotating device that converts ______ energy into ______ energy.",
          ["Electrical energy into Mechanical energy", "Mechanical energy into Electrical energy", "Heat energy into Light", "Chemical energy into Solar"], 0,
          "Motors utilize magnetic force on current-carrying coils to generate continuous rotational mechanical torque.", 1, "Easy", "Energy Transformation")
    add_q("C12_T1_3", 12, "Magnetic Effects of Electric Current", "Electromagnetic Induction Discovery", "TEST_1", "MCQ",
          "The phenomenon of producing an electric current in a closed coil by moving a magnet relative to the coil was discovered by:",
          ["Michael Faraday", "James Prescott Joule", "Andre-Marie Ampere", "Alessandro Volta"], 0,
          "Faraday's law of electromagnetic induction (1831) forms the basis of all electric generators and alternators.", 1, "Easy", "Induction History")
    add_q("C12_T1_4", 12, "Magnetic Effects of Electric Current", "Fleming's Right-Hand Rule", "TEST_1", "MCQ",
          "Fleming's Right-Hand Rule is applied in electrical generators to determine the direction of:",
          ["Induced electric current in the rotating conductor", "Magnetic field lines", "Force on stationary charge", "Battery voltage"], 0,
          "Right-hand generator rule: Thumb = motion of conductor, Forefinger = magnetic field, Central finger = induced current.", 1, "Medium", "Generator Rule")
    add_q("C12_T1_5", 12, "Magnetic Effects of Electric Current", "Domestic Circuit Color Codes", "TEST_1", "MCQ",
          "In domestic electrical wiring according to modern standards, the insulation colors for Live, Neutral, and Earth wires are respectively:",
          ["Red (or Brown); Black (or Blue); Green (or Green-Yellow)", "Green; Red; Black", "Black; Red; Yellow", "Blue; Green; White"], 0,
          "Live wire is red/brown (220V), neutral is black/blue (0V return), and earth is green/yellow (safety ground).", 1, "Easy", "Electrical Standards")
    add_q("C12_T1_6", 12, "Magnetic Effects of Electric Current", "Overloading Causes", "TEST_1", "MCQ",
          "Electrical overloading in a domestic circuit occurs when:",
          ["Too many high-power appliances (heaters, ACs, irons) are switched on simultaneously into a single socket", "Voltage drops to zero", "Switch is turned off", "Appliance has plastic body"], 0,
          "Connecting excessive loads draws current beyond the rated capacity of wires, triggering heat and potential electrical fires.", 1, "Easy", "Domestic Safety")

    # TEST_2 (6)
    add_q("C12_T2_1", 12, "Magnetic Effects of Electric Current", "Advantage of AC over DC", "TEST_2", "COMPETENCY_BASED",
          "The principal engineering advantage of Alternating Current (AC) over Direct Current (DC) for grid distribution is:",
          ["AC electric power can be transmitted over long distances using step-up transformers with minimal I^2*R heat energy loss", "AC is safe to touch", "AC requires no wires", "DC cannot run motors"], 0,
          "High voltage transmission lowers current (I), dramatically reducing line heating losses (P_loss = I^2*R) over hundreds of kilometres.", 1, "Hard", "Power Engineering")
    add_q("C12_T2_2", 12, "Magnetic Effects of Electric Current", "Maximum Magnetic Force Angle", "TEST_2", "COMPETENCY_BASED",
          "The mechanical force experienced by a current-carrying conductor placed inside a uniform magnetic field is MAXIMUM when the angle between conductor and field is:",
          ["90 degrees (perpendicular)", "0 degrees (parallel)", "180 degrees (anti-parallel)", "45 degrees"], 0,
          "F = B * I * L * sin(theta). Maximum force occurs at sin(90°) = 1; force is zero when parallel (sin 0° = 0).", 1, "Hard", "Lorentz Force Analysis")
    add_q("C12_T2_3", 12, "Magnetic Effects of Electric Current", "Clock Rule for Solenoid Poles", "TEST_2", "COMPETENCY_BASED",
          "When looking face-on at one end of a current-carrying circular coil, if current flows in an anticlockwise direction, that face behaves as a:",
          ["North magnetic pole (N-pole)", "South magnetic pole (S-pole)", "Neutral non-magnetic face", "Electrostatic cathode"], 0,
          "Clock Rule: Anticlockwise current corresponds to North pole; clockwise current corresponds to South pole.", 1, "Medium", "Polarity Determination")
    add_q("C12_T2_4", 12, "Magnetic Effects of Electric Current", "Galvanometer Function", "TEST_2", "COMPETENCY_BASED",
          "A galvanometer is an instrument connected in electric circuits primarily to:",
          ["Detect the presence and direction of minute electric currents", "Generate magnetic field", "Increase voltage", "Store electrical energy"], 0,
          "Galvanometer pointer deflects left or right depending on the direction of tiny microampere currents.", 1, "Easy", "Instrumentation")
    add_q("C12_T2_5", 12, "Magnetic Effects of Electric Current", "Earth Wire Circuit Breaker Action", "TEST_2", "COMPETENCY_BASED",
          "If the live wire inside a washing machine becomes loose and touches the metallic frame, what happens immediately if the frame is properly earthed?",
          ["A massive surge current flows safely to ground, instantly melting the fuse or tripping the MCB without electrocuting the user", "Machine runs twice as fast", "Water inside evaporates", "Machine stops working quietly"], 0,
          "Earth wire provides an ultra-low impedance path, driving high fault current that blows the fuse in milliseconds.", 1, "Hard", "Safety Engineering")
    add_q("C12_T2_6", 12, "Magnetic Effects of Electric Current", "Magnetic Field Proportionality to Current", "TEST_2", "COMPETENCY_BASED",
          "The strength of magnetic field produced at the center of a circular coil of radius r carrying current I with N turns is directly proportional to:",
          ["Number of turns (N) and current (I), and inversely proportional to radius (r)", "Only radius", "Inversely proportional to current", "Independent of turns"], 0,
          "B = (mu_0 * N * I) / (2r). Increasing coil turns adds concentric magnetic fields constructively.", 1, "Hard", "Field Equations")

    # TEST_3 (6)
    add_q("C12_T3_1", 12, "Magnetic Effects of Electric Current", "Assertion on Field Line Tangent", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): The tangent drawn at any point on a magnetic field line represents the direction of magnetic field at that point.\nReason (R): Two magnetic field lines can never cross or intersect each other.",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 1,
          "Both statements are true. If they intersected, two distinct tangents would exist at one point, implying two contradictory field directions.", 1, "Medium", "Board Pattern A/R")
    add_q("C12_T3_2", 12, "Magnetic Effects of Electric Current", "Alpha Particle Deflection", "TEST_3", "CASE_BASED",
          "A positively charged alpha particle projected towards West is deflected towards North by a magnetic field. What is the direction of the magnetic field?",
          ["Upward (perpendicular to plane)", "Downward", "Towards South", "Towards East"], 0,
          "Using Fleming's Left-Hand Rule: Thumb points North (Force), Middle finger points West (Current of positive charges); Forefinger points Upward (Field).", 1, "Hard", "Particle Deflection Problem")
    add_q("C12_T3_3", 12, "Magnetic Effects of Electric Current", "Commutator Split Rings Function", "TEST_3", "CASE_BASED",
          "In a DC electric motor, split-ring commutator functions to:",
          ["Reverse the direction of current in the rotating armature coil every half-rotation, maintaining continuous rotation in same direction", "Increase battery voltage", "Cool the carbon brushes", "Prevent coil from rotating"], 0,
          "Reversing current every 180 degrees keeps torque acting in a consistent unidirectional rotation.", 1, "Medium", "Motor Commutator")
    add_q("C12_T3_4", 12, "Magnetic Effects of Electric Current", "Two Current Ratings in Homes", "TEST_3", "CASE_BASED",
          "In domestic households, two separate circuits are wired: a 15 A circuit and a 5 A circuit. These are intended for:",
          ["15 A for high-power appliances (geysers, heaters, ACs); 5 A for low-power appliances (bulbs, fans, TV)", "15 A for kitchen only; 5 A for bedrooms", "15 A for AC current; 5 A for DC", "15 A for night; 5 A for day"], 0,
          "Higher current rating (15A) uses thicker gauge copper wire to handle high-wattage heating/cooling loads safely.", 1, "Easy", "Domestic Circuit Architecture")
    add_q("C12_T3_5", 12, "Magnetic Effects of Electric Current", "MRI Medical Imaging", "TEST_3", "CASE_BASED",
          "Magnetic Resonance Imaging (MRI) used in medical diagnostics to scan internal organs like brain and heart relies on:",
          ["Extremely weak magnetic fields generated naturally inside human body tissues by nerve ionic currents", "Radioactive isotopes", "Harmful X-rays", "Electric shock therapy"], 0,
          "Minute biomagnetic fields produced by heart and brain ionic currents are scanned using super-conducting magnets.", 1, "Medium", "Biomedical Application")
    add_q("C12_T3_6", 12, "Magnetic Effects of Electric Current", "MCB vs Traditional Fuse", "TEST_3", "CASE_BASED",
          "Miniature Circuit Breakers (MCBs) are preferred over traditional rewireable fuse wires in modern distribution boards because MCBs:",
          ["Automatically trip off mechanically during overcurrent and can be easily reset by flipping a switch without replacement", "Never trip", "Cost zero money", "Generate electricity"], 0,
          "MCBs use electromagnetic solenoids and bimetallic strips for fast, reusable, precise trip protection.", 1, "Easy", "Modern Protection")

    # REVISION (6)
    add_q("C12_REV_1", 12, "Magnetic Effects of Electric Current", "Quick Recall - Earth Magnetic Field Direction", "REVISION", "MCQ",
          "The Earth behaves like a giant bar magnet whose magnetic South pole is situated near Earth's:",
          ["Geographic North Pole", "Geographic South Pole", "Equator", "Atlantic ocean"], 0,
          "Because a compass North pole points towards geographic North, Earth's internal magnetic polarity near geographic North is a magnetic South pole.", 1, "Medium", "Geomagnetism")
    add_q("C12_REV_2", 12, "Magnetic Effects of Electric Current", "Quick Recall - Relative Closeness of Lines", "REVISION", "MCQ",
          "The degree of closeness of magnetic field lines in a region indicates the:",
          ["Relative strength of the magnetic field (denser lines mean stronger field)", "Speed of electricity", "Temperature of magnet", "Age of magnet"], 0,
          "Crowded field lines near poles signify high magnetic flux density and stronger magnetic force.", 1, "Easy", "Field Representation")
    add_q("C12_REV_3", 12, "Magnetic Effects of Electric Current", "Quick Recall - Neutral Wire Potential", "REVISION", "MCQ",
          "In domestic power distribution, the electric potential of the neutral wire is approximately:",
          ["0 Volts (ground potential)", "220 Volts", "440 Volts", "-220 Volts"], 0,
          "Neutral wire is earthed at local substation, holding it at ~0 V relative to earth.", 1, "Easy", "Standard Potentials")
    add_q("C12_REV_4", 12, "Magnetic Effects of Electric Current", "Quick Recall - Stationary Charge in Field", "REVISION", "MCQ",
          "A stationary electric charge Q at rest in a strong uniform magnetic field B experiences a magnetic force equal to:",
          ["Zero", "Q * B", "Infinite force", "Q / B"], 0,
          "Magnetic force acts only on moving charges: F = q * v * B * sin(theta); when velocity v = 0, F = 0.", 1, "Medium", "Lorentz Force Law")
    add_q("C12_REV_5", 12, "Magnetic Effects of Electric Current", "Quick Recall - Compass Needle Nature", "REVISION", "MCQ",
          "A magnetic compass needle is essentially a:",
          ["Small freely pivoted bar magnet", "Piece of unmagnetized copper", "Plastic pointer", "Electromagnet"], 0,
          "The compass needle is a delicate permanent magnet whose north-seeking pole aligns with ambient field lines.", 1, "Easy", "Compass Basics")
    add_q("C12_REV_6", 12, "Magnetic Effects of Electric Current", "Quick Recall - Permanent Magnet Material", "REVISION", "MCQ",
          "Permanent magnets used in loudspeakers and electric meters are typically manufactured from ferromagnetic alloys like:",
          ["Alnico (Aluminium-Nickel-Cobalt) or Carbon steel", "Soft iron", "Pure copper", "Lead"], 0,
          "Alnico has high magnetic retentivity and coercivity, retaining strong permanent magnetization indefinitely.", 1, "Easy", "Magnetic Materials")

    # ==========================================
    # CHAPTER 13: Our Environment (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C13_P_1", 13, "Our Environment", "10 Percent Energy Law", "PRACTICE", "MCQ",
          "If 10,000 Joules of solar energy is captured by green plants (producers), how much energy is transferred to secondary consumers (carnivores)?",
          ["100 Joules", "1,000 Joules", "10 Joules", "1 Joule"], 0,
          "Plant captures ~1% of solar (10,000 J). Herbivore gets 10% = 1,000 J. Carnivore gets 10% of 1,000 J = 100 J.", 1, "Medium", "Lindeman Law")
    add_q("C13_P_2", 13, "Our Environment", "Biological Magnification", "PRACTICE", "MCQ",
          "The phenomenon where non-biodegradable toxic pesticides (e.g. DDT) accumulate in increasing concentrations at each successive trophic level is:",
          ["Biological Magnification (Biomagnification)", "Eutrophication", "Bio-accumulation index", "Bioremediation"], 0,
          "Because non-biodegradable chemicals cannot be metabolized or excreted, their concentration multiplies at each trophic step.", 1, "Easy", "Ecotoxicology")
    add_q("C13_P_3", 13, "Our Environment", "Ozone Depletion Chemical", "PRACTICE", "MCQ",
          "The depletion of the protective ozone layer (O3) in the stratosphere is primarily caused by synthetic chemicals known as:",
          ["Chlorofluorocarbons (CFCs)", "Carbon monoxide (CO)", "Methane (CH4)", "Sulphur dioxide (SO2)"], 0,
          "CFCs used in refrigeration release chlorine free radicals under UV light, catalytically decomposing thousands of O3 molecules.", 1, "Easy", "Atmospheric Pollution")
    add_q("C13_P_4", 13, "Our Environment", "Decomposers Ecological Role", "PRACTICE", "MCQ",
          "What crucial ecological service is performed by decomposers (bacteria and saprophytic fungi) in natural ecosystems?",
          ["They break down dead organic matter into simple inorganic nutrients, replenishing soil fertility", "They produce oxygen through photosynthesis", "They act as top apex predators", "They generate solar energy"], 0,
          "Decomposers close biogeochemical nutrient cycles, returning carbon, nitrogen, and phosphorus back to soil and air.", 1, "Easy", "Ecosystem Function")
    add_q("C13_P_5", 13, "Our Environment", "Unidirectional Energy Flow", "PRACTICE", "MCQ",
          "Energy flow in an ecosystem is strictly unidirectional because:",
          ["Energy captured by autotrophs cannot revert back to the sun, and energy passed to herbivores cannot return to plants", "Nutrients cycle back to sun", "Decomposers generate light", "Energy multiplies upwards"], 0,
          "Energy dissipates progressively as non-recoverable metabolic heat (entropy) at each trophic transition.", 1, "Medium", "Thermodynamics in Ecosystem")
    add_q("C13_P_6", 13, "Our Environment", "Ozone Layer Shield", "PRACTICE", "MCQ",
          "The stratospheric ozone layer shields biological life on Earth from harmful:",
          ["Ultraviolet (UV-B) radiation from the Sun", "Infrared heat waves", "Cosmic gamma rays only", "Visible blue light"], 0,
          "UV radiation causes human skin cancers, cataracts, genetic mutations, and damages marine phytoplankton.", 1, "Easy", "Ozone Function")

    # TEST_1 (6)
    add_q("C13_T1_1", 13, "Our Environment", "Biotic vs Abiotic Components", "TEST_1", "MCQ",
          "Which of the following consists exclusively of abiotic components of an ecosystem?",
          ["Temperature, Rainfall, Soil, Sunlight, and Wind", "Trees, Birds, Insects, and Bacteria", "Fish, Algae, and Protozoa", "Fungi and Producers"], 0,
          "Abiotic factors are non-living physical and climatic environmental parameters.", 1, "Easy", "Ecosystem Architecture")
    add_q("C13_T1_2", 13, "Our Environment", "Food Web Stability", "TEST_1", "MCQ",
          "A complex network of interconnected food chains operating in an ecosystem is called a:",
          ["Food Web", "Trophic Pyramid", "Biomass Column", "Ecological Niche"], 0,
          "Food webs provide alternative feeding pathways, imparting resilience and ecological stability against species extinction.", 1, "Easy", "Trophic Ecology")
    add_q("C13_T1_3", 13, "Our Environment", "Trophic Levels Limit", "TEST_1", "MCQ",
          "Why do food chains in nature rarely consist of more than 4 or 5 trophic levels?",
          ["Because by Lindeman's 10% law, so little usable energy remains at higher levels that it cannot support viable populations", "Predators refuse to eat each other", "Animals cannot grow larger", "Sunlight stops working"], 0,
          "90% energy loss at each step leaves insufficient caloric energy to sustain a trophic tier beyond apex carnivores.", 1, "Medium", "Trophic Dynamics")
    add_q("C13_T1_4", 13, "Our Environment", "Biodegradable vs Non-biodegradable", "TEST_1", "MCQ",
          "Which of the following waste materials is completely biodegradable by bacterial and fungal enzymes?",
          ["Cotton cloth, Paper, and Vegetable peels", "Plastic carry bags and PET bottles", "DDT and heavy metal lead", "Glass bottles"], 0,
          "Natural organic plant celluloses and starches can be broken down by saprophytic microbial enzymes.", 1, "Easy", "Waste Classification")
    add_q("C13_T1_5", 13, "Our Environment", "Montreal Protocol 1987", "TEST_1", "MCQ",
          "The landmark international treaty signed in 1987 by UNEP to freeze and phase out CFC production globally is the:",
          ["Montreal Protocol", "Kyoto Protocol", "Paris Agreement", "Geneva Convention"], 0,
          "The Montreal Protocol successfully curtailed ozone-depleting halogenated substances worldwide.", 1, "Easy", "Environmental Treaties")
    add_q("C13_T1_6", 13, "Our Environment", "Aquarium Cleaning Necessity", "TEST_1", "MCQ",
          "Why does an artificial aquarium require regular cleaning and water filtration, while natural ponds and lakes do not?",
          ["An aquarium is an incomplete artificial ecosystem lacking natural decomposers and self-cleansing nutrient cycles", "Pond fish do not excrete", "Aquarium glass attracts bacteria", "Aquarium water has no oxygen"], 0,
          "Without balanced bacterial decomposers and natural food webs, toxic fish ammonia wastes accumulate in aquariums.", 1, "Medium", "Artificial Ecosystems")

    # TEST_2 (6)
    add_q("C13_T2_1", 13, "Our Environment", "Highest Biomagnification Level", "TEST_2", "COMPETENCY_BASED",
          "In a four-step food chain: Phytoplankton -> Zooplankton -> Small Fish -> Human, which organism will accumulate the highest concentration of toxic DDT?",
          ["Human (top apex consumer)", "Phytoplankton", "Zooplankton", "Small fish"], 0,
          "Humans sit at the apex of the aquatic trophic pyramid where accumulated lifetime non-biodegradable toxins reach peak concentrations.", 1, "Medium", "Biomagnification Application")
    add_q("C13_T2_2", 13, "Our Environment", "Ozone Formation Reaction", "TEST_2", "COMPETENCY_BASED",
          "In the stratosphere, ozone (O3) is formed by high-energy UV radiation through which photochemical reactions?",
          ["O2 -(UV)-> O + O, followed by O + O2 -> O3", "CO2 + H2O -> O3", "N2 + O2 -> O3", "2O -> O2 + Heat"], 0,
          "Photodissociation splits molecular oxygen into nascent oxygen atoms, which combine with O2 to produce ozone.", 1, "Medium", "Stratospheric Chemistry")
    add_q("C13_T2_3", 13, "Our Environment", "Disposal of Biodegradable Waste", "TEST_2", "COMPETENCY_BASED",
          "The most eco-friendly method for managing municipal kitchen organic wet waste is:",
          ["Composting and Biogas generation", "Open burning in streets", "Dumping into ocean rivers", "Plastic bag landfilling"], 0,
          "Composting converts organic matter into nutrient-rich humus fertilizer and renewable methane biogas without air pollution.", 1, "Easy", "Waste Management")
    add_q("C13_T2_4", 13, "Our Environment", "Kulhads Clay Cups Environmental Impact", "TEST_2", "COMPETENCY_BASED",
          "Why was the massive introduction of disposable earthen clay cups (kulhads) on Indian railway stations discontinued?",
          ["Making millions of kulhads resulted in extensive loss of fertile agricultural topsoil", "Kulhads are toxic to drink from", "Plastic is cheaper to burn", "Clay cups pollute groundwater"], 0,
          "Mining millions of tons of topsoil for clay cups stripped fertile topsoil essential for agriculture.", 1, "Medium", "Case Analysis")
    add_q("C13_T2_5", 13, "Our Environment", "First Trophic Level Solar Absorption", "TEST_2", "COMPETENCY_BASED",
          "Terrestrial green plants capture approximately what percentage of the total incident solar radiation falling on their leaves for photosynthesis?",
          ["1 percent (about 1%)", "10 percent", "50 percent", "100 percent"], 0,
          "Autotrophs convert roughly 1% of total incident sunlight energy into chemical food energy.", 1, "Hard", "Energy Budget")
    add_q("C13_T2_6", 13, "Our Environment", "Incineration in Hospitals", "TEST_2", "COMPETENCY_BASED",
          "Hospital biomedical hazardous waste (infected syringes, dressings, pathological tissue) is safely disposed of by:",
          ["High-temperature controlled Incineration", "Open backyard composting", "Dumping in community gardens", "Recycling into toys"], 0,
          "Incinerators operating at >1000°C completely combust infectious pathogens and medical biohazards into sterile ash.", 1, "Easy", "Biohazard Safety")

    # TEST_3 (6)
    add_q("C13_T3_1", 13, "Our Environment", "Assertion on Biomagnification", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): Vegetarians occupying the primary consumer level accumulate significantly lower pesticide residues than non-vegetarians eating carnivore fish.\nReason (R): Pesticides magnify exponentially with each step; shorter food chains experience substantially less biomagnification.",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "Eating at trophic level 2 (plants) avoids the multiplicative accumulation seen at trophic levels 3 and 4.", 1, "Medium", "Board Pattern A/R")
    add_q("C13_T3_2", 13, "Our Environment", "Food Chain Biomass Pyramid", "TEST_3", "CASE_BASED",
          "In a terrestrial grassland ecosystem, the pyramid of biomass is upright because:",
          ["Total dry biomass of primary producers (grasses) exceeds that of herbivores, which exceeds carnivores", "Carnivores weigh more than trees", "Decomposers have zero weight", "Biomass is inverted in air"], 0,
          "Energy attenuation restricts the standing crop biomass supported at higher trophic tiers in land biomes.", 1, "Medium", "Biomass Pyramids")
    add_q("C13_T3_3", 13, "Our Environment", "Non-biodegradable Plastics Hazard", "TEST_3", "CASE_BASED",
          "Plastic bags and synthetic polymers persist in the environment for centuries without decomposing because:",
          ["Microbial decomposers lack specific catabolic enzymes capable of cleaving synthetic carbon-carbon polymer bonds", "Plastics are made of water", "Plastics are metals", "Bacteria eat only glass"], 0,
          "Enzymes are substrate-specific; microorganisms evolved enzymes for natural celluloses and proteins, not synthetic polymers.", 1, "Medium", "Enzymatic Specificity")
    add_q("C13_T3_4", 13, "Our Environment", "Top Consumer Removal Impact", "TEST_3", "CASE_BASED",
          "What happens if all apex predators (tigers and lions) are completely removed from a forest ecosystem?",
          ["Herbivore deer populations explode uncontrollably, leading to overgrazing, loss of vegetation, and eventual ecosystem collapse", "Trees grow 10 times taller", "Rainfall doubles", "Food web becomes permanent"], 0,
          "Apex carnivores exert top-down population regulation; removing them disrupts ecological trophic equilibrium.", 1, "Medium", "Ecosystem Homeostasis")
    add_q("C13_T3_5", 13, "Our Environment", "Ozone Layer Thickness Measurement", "TEST_3", "CASE_BASED",
          "The column thickness of stratospheric ozone layer is measured in which scientific unit?",
          ["Dobson Units (DU)", "Decibels (dB)", "Pascals (Pa)", "Becquerel (Bq)"], 0,
          "1 Dobson Unit represents a 0.01 mm thick layer of pure ozone at standard temperature and pressure (normal ozone layer is ~300 DU).", 1, "Hard", "Scientific Units")
    add_q("C13_T3_6", 13, "Our Environment", "Landfill Gas Methane", "TEST_3", "CASE_BASED",
          "Deep municipal sanitary landfills generate flammable landfill gas due to anaerobic digestion of organic matter. The major gas is:",
          ["Methane (CH4)", "Nitrogen", "Oxygen", "Helium"], 0,
          "Methanogenic bacteria decomposing buried organic refuse produce methane (~50%) and carbon dioxide.", 1, "Easy", "Landfill Chemistry")

    # REVISION (6)
    add_q("C13_REV_1", 13, "Our Environment", "Quick Recall - Ecosystem Term Coinage", "REVISION", "MCQ",
          "The term 'Ecosystem' was first coined in 1935 by the British ecologist:",
          ["A.G. Tansley", "Charles Darwin", "Gregor Mendel", "E. Haeckel"], 0,
          "Sir Arthur Tansley defined an ecosystem as the integrated unit of biotic community and abiotic habitat.", 1, "Easy", "Rapid Recall")
    add_q("C13_REV_2", 13, "Our Environment", "Quick Recall - Trophic Level 1", "REVISION", "MCQ",
          "The first trophic level (T1) in all natural ecosystems is occupied by:",
          ["Autotrophic Producers (Green plants and Phytoplankton)", "Herbivores", "Carnivores", "Decomposers"], 0,
          "Producers synthesize organic glucose from inorganic CO2 and water utilizing solar energy.", 1, "Easy", "Rapid Recall")
    add_q("C13_REV_3", 13, "Our Environment", "Quick Recall - Herbivore Trophic Level", "REVISION", "MCQ",
          "Herbivores (such as cows, deer, and rabbits) that feed directly on producers occupy the:",
          ["Second trophic level (T2, Primary Consumers)", "First trophic level", "Third trophic level", "Top apex level"], 0,
          "Herbivores are primary consumers at the second trophic level.", 1, "Easy", "Rapid Recall")
    add_q("C13_REV_4", 13, "Our Environment", "Quick Recall - Carnivore Trophic Level", "REVISION", "MCQ",
          "Small carnivores that feed on herbivores (e.g. frogs eating insects) occupy the:",
          ["Third trophic level (T3, Secondary Consumers)", "First trophic level", "Fourth trophic level", "Fifth trophic level"], 0,
          "Secondary consumers feed on primary consumers at the third trophic tier.", 1, "Easy", "Rapid Recall")
    add_q("C13_REV_5", 13, "Our Environment", "Quick Recall - Ozone Atomicity", "REVISION", "MCQ",
          "Ozone is a triatomic molecule consisting of how many oxygen atoms bonded together?",
          ["3 oxygen atoms (O3)", "2 oxygen atoms (O2)", "1 oxygen atom", "4 oxygen atoms (O4)"], 0,
          "Ozone consists of three oxygen atoms (O3), acting as a poisonous gas at ground level but a vital shield in stratosphere.", 1, "Easy", "Molecular Formula")
    add_q("C13_REV_6", 13, "Our Environment", "Quick Recall - 3 R's of Environment", "REVISION", "MCQ",
          "The classical 3 R's strategy for sustainable natural resource conservation and waste minimization stands for:",
          ["Reduce, Reuse, Recycle", "Refuse, Repair, Recover", "Renew, Rebuild, React", "Run, Rest, Repeat"], 0,
          "Reduce consumption, Reuse materials, and Recycle recyclable wastes.", 1, "Easy", "Conservation Strategy")

    print("Chapters 9-13 added (150 questions).")
