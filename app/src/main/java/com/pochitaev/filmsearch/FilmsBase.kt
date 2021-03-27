package com.pochitaev.filmsearch


class FilmsBase<List>(val title: String, val poster: Int, val description: String, var isInFavorites: Boolean) {

    init {
          Film("Attack on titans", R.drawable.attackontitans, "Загнанное в угол человечество доживает свои последние дни под гнётом титанов - таинственных созданий, терроризирующих человеческую расу. Выжившие ютятся за стенами крупного поселения с собственным правительством, представляющим последний оплот централизованной власти в мире.", isInFavorites = false)
          Film("BreakingBad",R.drawable.breaking,"«Во все тяжкие» рассказывает историю отчаявшегося школьного учителя химии Уолтера Уайта, который ради того, чтобы прокормить семью, решается на самые крайние меры.", isInFavorites = false)
          Film("Bridgerton",R.drawable.bridgerton,"Wealth, lust, and betrayal set against the backdrop of Regency-era England, seen through the eyes of the powerful Bridgerton family.", isInFavorites = false)
          Film("Fate: The Winx Saga",R.drawable.fate,"It follows Bloom as she adjusts to life in the Otherworld, where she must learn to control her dangerous magical powers.", isInFavorites = false)
          Film("Game of Thrones",R.drawable.got,"Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.", isInFavorites = false)
          Film("Interstellar",R.drawable.inter,"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", isInFavorites = false)
          Film("Lupin",R.drawable.lupin,"Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.", isInFavorites = false)
          Film("Promising Young Woman",R.drawable.perspective,"A young woman, traumatized by a tragic event in her past, seeks out vengeance against those who crossed her path.", isInFavorites = false)
          Film("Soul",R.drawable.soul,"After landing the gig of a lifetime, a New York jazz pianist suddenly finds himself trapped in a strange land between Earth and the afterlife.", isInFavorites = false)
          Film("The Wolf of Wall Street",R.drawable.wolf,"Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", isInFavorites = false)

    }

}