package game.wordRepo;

import game.exceptions.GameException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordRepo {
    private static final SecureRandom RANDOM = new SecureRandom();

    private final Map<String, List<WordData>> wordMap = new HashMap<>();

    public WordRepo() {
        List<WordData> words = List.of(
                // Базовые понятия
                new WordData("atom",
                        "The basic unit of a chemical element.",
                        Category.BASIC_CONCEPTS,
                        Difficulty.EASY),
                new WordData("nucleus",
                        "The positively charged center of an atom.",
                        Category.BASIC_CONCEPTS,
                        Difficulty.EASY),
                new WordData("proton",
                        "Positively charged particle in the atomic nucleus.",
                        Category.BASIC_CONCEPTS,
                        Difficulty.EASY),
                new WordData("neutron",
                        "Neutral particle found in the nucleus of an atom.",
                        Category.BASIC_CONCEPTS,
                        Difficulty.EASY),
                new WordData("electron",
                        "Negatively charged particle orbiting the nucleus.",
                        Category.BASIC_CONCEPTS,
                        Difficulty.EASY),
                new WordData("ion",
                        "An atom with a net electric charge due to loss or gain of electrons.",
                        Category.BASIC_CONCEPTS,
                        Difficulty.MEDIUM),
                new WordData("isotope",
                        "Atoms of the same element with different numbers of neutrons.",
                        Category.BASIC_CONCEPTS,
                        Difficulty.MEDIUM),

                // Реакции и процессы
                new WordData("fission",
                        "The process of splitting a heavy nucleus into two lighter nuclei.",
                        Category.REACTIONS,
                        Difficulty.MEDIUM),
                new WordData("fusion",
                        "The process of combining two light nuclei to form a heavier nucleus.",
                        Category.REACTIONS,
                        Difficulty.MEDIUM),
                new WordData("radioactivity",
                        "The spontaneous emission of particles or radiation from an unstable nucleus.",
                        Category.REACTIONS,
                        Difficulty.HARD),
                new WordData("half-life",
                        "The time required for half of a radioactive substance to decay.",
                        Category.REACTIONS,
                        Difficulty.HARD),
                new WordData("chain_reaction",
                        "A sequence of reactions where a reactive product causes additional reactions.",
                        Category.REACTIONS,
                        Difficulty.HARD),

                // Виды распада
                new WordData("alpha_decay",
                        "Type of radioactive decay that emits helium nuclei.",
                        Category.DECAY,
                        Difficulty.HARD),
                new WordData("beta_decay",
                        "Type of radioactive decay that emits electrons or positrons.",
                        Category.DECAY,
                        Difficulty.HARD),
                new WordData("gamma_radiation",
                        "High-energy electromagnetic radiation emitted by nuclear reactions.",
                        Category.DECAY,
                        Difficulty.HARD),
                new WordData("positron_emission",
                        "Type of beta decay where a positron is emitted.",
                        Category.DECAY,
                        Difficulty.HARD),
                new WordData("neutron_emission",
                        "Release of neutrons from the nucleus during radioactive decay.",
                        Category.DECAY,
                        Difficulty.HARD),

                // Частицы и их свойства
                new WordData("quark",
                        "Elementary particle that makes up protons and neutrons.",
                        Category.PARTICLES,
                        Difficulty.HARD),
                new WordData("lepton",
                        "Elementary particle like an electron or neutrino.",
                        Category.PARTICLES,
                        Difficulty.HARD),
                new WordData("neutrino",
                        "Very light and neutral elementary particle emitted in some radioactive decays.",
                        Category.PARTICLES,
                        Difficulty.HARD),
                new WordData("gluon",
                        "Elementary particle that acts as the exchange particle for the strong force between quarks.",
                        Category.PARTICLES,
                        Difficulty.HARD),
                new WordData("photon",
                        "Elementary particle representing a quantum of light or other electromagnetic radiation.",
                        Category.PARTICLES,
                        Difficulty.MEDIUM),

                // Технологии и устройства
                new WordData("cyclotron",
                        "Device used to accelerate charged particles using a magnetic field.",
                        Category.TECHNOLOGY,
                        Difficulty.MEDIUM),
                new WordData("reactor",
                        "A device used to initiate and control nuclear fission reactions.",
                        Category.TECHNOLOGY,
                        Difficulty.MEDIUM),
                new WordData("control_rod",
                        "Component in a nuclear reactor used to control the rate of fission.",
                        Category.TECHNOLOGY,
                        Difficulty.HARD),
                new WordData("enrichment",
                        "The process of increasing the proportion of a particular isotope in a material.",
                        Category.TECHNOLOGY,
                        Difficulty.HARD),
                new WordData("particle_accelerator",
                        "A machine that accelerates atomic or subatomic particles to high speeds.",
                        Category.TECHNOLOGY,
                        Difficulty.HARD),
                new WordData("tokamak",
                        "A device that uses magnetic fields to confine plasma in nuclear fusion research.",
                        Category.TECHNOLOGY,
                        Difficulty.HARD),

                // Исторические события и объекты
                new WordData("chernobyl",
                        "Site of the most infamous nuclear disaster in 1986.",
                        Category.HISTORY,
                        Difficulty.MEDIUM),
                new WordData("hiroshima",
                        "City in Japan where the first atomic bomb was dropped in 1945.",
                        Category.HISTORY,
                        Difficulty.MEDIUM),
                new WordData("trinity_test",
                        "The first detonation of a nuclear device by the United States in 1945.",
                        Category.HISTORY,
                        Difficulty.HARD),
                new WordData("manhattan_project",
                        "Research project that developed the first nuclear weapons during World War II.",
                        Category.HISTORY,
                        Difficulty.HARD),
                new WordData("fukushima",
                        "Nuclear disaster that occurred in Japan in 2011 following an earthquake and tsunami.",
                        Category.HISTORY,
                        Difficulty.HARD),

                // Экологические аспекты и безопасность
                new WordData("nuclear_waste",
                        "Radioactive materials remaining after nuclear reactions.",
                        Category.ENVIRONMENT,
                        Difficulty.HARD),
                new WordData("decommissioning",
                        "The process of safely closing and dismantling a nuclear facility.",
                        Category.ENVIRONMENT,
                        Difficulty.HARD),
                new WordData("contamination",
                        "Presence of radioactive substances in the environment.",
                        Category.ENVIRONMENT,
                        Difficulty.HARD),
                new WordData("radiation_shielding",
                        "Materials or devices used to protect against harmful radiation.",
                        Category.SAFETY,
                        Difficulty.HARD),
                new WordData("dosimeter",
                        "Device that measures exposure to ionizing radiation.",
                        Category.SAFETY,
                        Difficulty.MEDIUM),
                new WordData("protective_suit",
                        "Clothing designed to protect the wearer from radiation exposure.",
                        Category.SAFETY,
                        Difficulty.MEDIUM),
                new WordData("evacuation_protocol",
                        "A set of procedures for safely leaving a dangerous area in the event of radiation exposure.",
                        Category.SAFETY,
                        Difficulty.HARD),
                new WordData("emergency_cooling",
                        "System in a nuclear reactor to prevent overheating during accidents.",
                        Category.SAFETY,
                        Difficulty.HARD)
        );


        for (WordData word : words) {
            String key = generateKey(word.category(), word.difficulty());
            wordMap.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
    }

    public WordData getRandomWord(Category category, Difficulty difficulty) {
        String key = generateKey(category, difficulty);
        List<WordData> filteredWords = wordMap.get(key);

        if (filteredWords == null || filteredWords.isEmpty()) {
            throw new GameException("Can't find words for the given category and difficulty.");
        }

        return filteredWords.get(RANDOM.nextInt(filteredWords.size()));
    }

    private String generateKey(Category category, Difficulty difficulty) {
        return category.toString() + "_" + difficulty.toString();
    }
}
