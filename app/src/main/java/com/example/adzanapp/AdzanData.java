package com.example.adzanapp;

import java.util.ArrayList;
import java.util.List;

public class AdzanData {

    public static List<AdzanModel> getList() {
        List<AdzanModel> list = new ArrayList<>();

        // ================= INDONESIA =================
        list.add(new AdzanModel(
                "Indonesia",
                "Ruli Maroya",
                R.raw.adzan_indonesia,
                R.drawable.flag_indonesia,
                new String[]{
                        "الله أكبر الله أكبر",
                        "الله أكبر الله أكبر",
                        "أشهد أن لا إله إلا الله",
                        "أشهد أن لا إله إلا الله",
                        "أشهد أن محمدًا رسول الله",
                        "أشهد أن محمدًا رسول الله",
                        "حي على الصلاة",
                        "حي على الصلاة",
                        "حي على الفلاح",
                        "حي على الفلاح",
                        "الله أكبر الله أكبر",
                        "لا إله إلا الله"
                },
                new String[]{
                        "Allahu Akbar Allahu Akbar",
                        "Allahu Akbar Allahu Akbar",
                        "Asyhadu alla ilaha illallah",
                        "Asyhadu alla ilaha illallah",
                        "Asyhadu anna Muhammadar Rasulullah",
                        "Asyhadu anna Muhammadar Rasulullah",
                        "Hayya 'alash shalah",
                        "Hayya 'alash shalah",
                        "Hayya 'alal falah",
                        "Hayya 'alal falah",
                        "Allahu Akbar Allahu Akbar",
                        "La ilaha illallah"
                },
                new int[]{
                        6000, 30000,
                        22000, 29000,
                        30000, 30000,
                        30000, 35000,
                        31000, 29000,
                        20000,
                        19000
                }
        ));

        // ================= MEKKAH =================
        list.add(new AdzanModel(
                "Mekkah",
                "Abdul Aziz Zahrani",
                R.raw.adzan_mekah,
                R.drawable.flag_saudi,
                new String[]{
                        "الله أكبر الله أكبر",
                        "الله أكبر الله أكبر",
                        "أشهد أن لا إله إلا الله",
                        "أشهد أن لا إله إلا الله",
                        "أشهد أن محمدًا رسول الله",
                        "أشهد أن محمدًا رسول الله",
                        "حي على الصلاة",
                        "حي على الصلاة",
                        "حي على الفلاح",
                        "حي على الفلاح",
                        "الله أكبر الله أكبر",
                        "لا إله إلا الله"
                },
                new String[]{
                        "Allahu Akbar Allahu Akbar",
                        "Allahu Akbar Allahu Akbar",
                        "Asyhadu alla ilaha illallah",
                        "Asyhadu alla ilaha illallah",
                        "Asyhadu anna Muhammadar Rasulullah",
                        "Asyhadu anna Muhammadar Rasulullah",
                        "Hayya 'alash shalah",
                        "Hayya 'alash shalah",
                        "Hayya 'alal falah",
                        "Hayya 'alal falah",
                        "Allahu Akbar Allahu Akbar",
                        "La ilaha illallah"
                },
                new int[]{
                        25000, 20000,
                        23000, 19000,
                        31000, 30000,
                        27000, 15000,
                        29000, 19000,
                        17000,
                        17000
                }
        ));

        // ================= MALAYSIA =================
        list.add(new AdzanModel(
                "Malaysia",
                "Fahmi Asraf",
                R.raw.adzan_malaysia,
                R.drawable.flag_malaysia,
                new String[]{
                        "الله أكبر الله أكبر",
                        "الله أكبر الله أكبر",
                        "أشهد أن لا إله إلا الله",
                        "أشهد أن لا إله إلا الله",
                        "أشهد أن محمدًا رسول الله",
                        "أشهد أن محمدًا رسول الله",
                        "حي على الصلاة",
                        "حي على الصلاة",
                        "حي على الفلاح",
                        "حي على الفلاح",
                        "الله أكبر الله أكبر",
                        "لا إله إلا الله"
                },
                new String[]{
                        "Allahu Akbar Allahu Akbar",
                        "Allahu Akbar Allahu Akbar",
                        "Asyhadu alla ilaha illallah",
                        "Asyhadu alla ilaha illallah",
                        "Asyhadu anna Muhammadar Rasulullah",
                        "Asyhadu anna Muhammadar Rasulullah",
                        "Hayya 'alash shalah",
                        "Hayya 'alash shalah",
                        "Hayya 'alal falah",
                        "Hayya 'alal falah",
                        "Allahu Akbar Allahu Akbar",
                        "La ilaha illallah"
                },
                new int[]{
                        30000, 34000,
                        27000, 34000,
                        23000, 21000,
                        25000, 20000,
                        32000, 15000,
                        19000,
                        19000
                }
        ));

        return list;
    }
}


