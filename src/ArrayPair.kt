class ArrayPair<K, T>(array: Array<K>, inverseArray: Array<T>, size: Int): Iterator<Pair<K, T>> {
    var counter = 0
    var size = 0
    var array: Array<K>? = null
    var inverseArray: Array<T>? = null
    init {
        this.counter = 0
        this.size = size
        this.array = array
        this.inverseArray = inverseArray
    }
    override fun next(): Pair<K, T> {
        val tempPair = Pair(array!![counter], inverseArray!![counter])
        counter++
        return tempPair
    }
    override fun hasNext(): Boolean {
        val tempCounter = counter
        return if (tempCounter < this.size) {
            array!![tempCounter] != null && inverseArray!![tempCounter] != null
        }
        else {
            false
        }
    }
}