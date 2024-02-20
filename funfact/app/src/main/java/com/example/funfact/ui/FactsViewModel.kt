package com.example.funfact.ui

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel(){

    fun generateRandomFact(selectedAnimal:String):String{
        return if (selectedAnimal=="Köpek"){
            getDogFacts().random()
        }else{
            getCatFacts().random()
        }
    }

    fun getDogFacts():List<String>{
        val dogFacts= listOf(
                    "Köpekler, insanlardan çok daha iyi koku alabilirler.",
                    "Bazı köpekler tıbbi sorunları tespit etmek için eğitilebilir.",
                    "Bir köpeğin sağlıklı olduğu dilinin pembeliğinden anlaşılabilir.",
                    "Köpekler, insanlar gibi ruh hallerini ifade edebilirler.",
                    "Köpekler, doğdukları andan itibaren insanlara karşı sevgi duyarlar.",
                    "Bazı köpek ırklarının dilleri siyahtır, örneğin Chow Chow.",
                    "Köpekler, insanların sosyal sinyallerini anlayabilirler. ",
                    "Köpekler, insanların yüz ifadelerini okuyabilirler.",
                    "Köpekler, insanların duygusal durumlarını hissedebilirler.",
                    "Köpekler, insanların stres seviyelerini azaltabilirler.",
                    "Köpekler, insanların sağlıklı bir yaşam sürmelerine yardımcı olabilirler.",
                    "Köpekler, insanların depresyon ve anksiyete semptomlarını hafifletebilirler.",
                    "Köpekler, insanların sosyal bağlarını güçlendirebilirler.",
                    "Köpekler, insanların egzersiz yapmalarına teşvik edebilirler.",
                    "Köpekler, insanların yaşam kalitesini artırabilirler."
        )
        return dogFacts
    }
    fun getCatFacts():List<String> {
        val catFacts = listOf(
                    "Dünya üzerinde 34 farklı kedi ırkı bulunmaktadır.",
                    "Kedilerin kalbi, insanların kalbine göre yaklaşık olarak 2 kat daha hızlı atar.",
                    "Kediler de insanlar gibi rüya görürler.",
                    "Kediler, insanların yaklaşık %12'sine kendilerini sevdirebilmiştir.",
                    "Türkiye'de seçim sonuçlarını sabote edebilen tek canlı kedidir.",
                    "Kedilerin 180 derecelik görüş açısı vardır ve geniş bir alanı ayrıntılarıyla görebilirler.",
                    "Kedileri okşamanın kan basıncını düşürdüğü bilimsel olarak kanıtlanmıştır.",
                    "Kediler mükemmel bir dengeye sahiptir ve her zaman patileri üzerine düşmezler. Vücutlarındaki arka kasları çalıştırarak dengeyi sağlarlar.",
                    "Kediler, insanların yüz ifadelerini okuyabilirler.",
                    "Kediler, insanların duygusal durumlarını hissedebilirler.",
                    "Kediler, insanların stres seviyelerini azaltabilirler.",
                    "Kediler, insanların sağlıklı bir yaşam sürmelerine yardımcı olabilirler.",
                    "Kediler, insanların depresyon ve anksiyete semptomlarını hafifletebilirler.",
                    "Kediler, insanların sosyal bağlarını güçlendirebilirler.",
                    "Kediler, insanların yaşam kalitesini artırabilirler.",
        )
        return catFacts
    }

}