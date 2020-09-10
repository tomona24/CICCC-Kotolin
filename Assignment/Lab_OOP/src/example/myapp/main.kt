package example.myapp

fun buildAquarium() {
    val aquarium = Aquarium(width = 25, length = 25, height = 40)
    aquarium.printSize()

    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()


}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main() {
//    buildAquarium()

    makeFish()
}