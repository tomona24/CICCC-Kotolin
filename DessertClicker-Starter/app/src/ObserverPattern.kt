
// Observable
interface Subject {
    fun attach(ob: Observer)
    fun detach(ob: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update()
}

class ClockTimer(): Subject {
    private val observers: MutableList<Observer> = mutableListOf()
    var second: Int = 0
        private set

    override fun attach(ob: Observer) {
        observers.add(ob)
    }

    override fun detach(ob: Observer) {
        observers.remove(ob)
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update()
        }
    }

    fun tick() {
        second += 1
        notifyObservers()
    }
}

class AnalogClock(val subject: ClockTimer): Observer {
    override fun update() {
        println("AnalogClock ${subject.second}")
    }
}

class DigitalClock(val subject: ClockTimer): Observer {
    override fun update() {
        println("DigitalClock ${subject.second}")
    }
}

fun main() {
    val timer = ClockTimer()
    val analog = AnalogClock(timer)
    val digital = DigitalClock(timer)

    timer.attach(analog)
    timer.attach(digital)

    timer.tick()
    timer.tick()
    timer.tick()
    timer.tick()
    timer.tick()
}















