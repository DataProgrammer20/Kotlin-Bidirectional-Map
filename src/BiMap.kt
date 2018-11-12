class BiMap<K, T> {
    var map: Map<K, T>? = null
    var inverseMap: Map<T, K>? = null
    // Convert arrays to bidirectional map
    constructor(array: Array<K>, inverseArray: Array<T>) {
        this.map = arrayMapOf(array, inverseArray)
        this.inverseMap = arrayMapOfInverse(inverseArray, array)
    }
    // Empty Constructor
    constructor() {
        this.map = emptyMap()
        this.inverseMap = emptyMap()
    }
    // Convert array into map
    private fun arrayMapOf(array: Array<K>, inverseArray: Array<T>): Map<K, T> {
        val newMap: MutableMap<K, T> = mutableMapOf()
        val pairs = ArrayPair(array, inverseArray, array.size)
        for (itemPair in pairs) {
            newMap.put(itemPair.first, itemPair.second)
        }
        return newMap
    }
    // Convert inverse array into map
    private fun arrayMapOfInverse(array: Array<T>, inverseArray: Array<K>): Map<T, K> {
        val newMap: MutableMap<T, K> = mutableMapOf()
        val pairs = ArrayPair(array, inverseArray, array.size)
        for (itemPair in pairs) {
            newMap.put(itemPair.first, itemPair.second)
        }
        return newMap
    }
    fun getKey(value: T): K? { return this.inverseMap?.getValue(value) }
    fun getValue(key: K): T? { return this.map?.getValue(key) }
}