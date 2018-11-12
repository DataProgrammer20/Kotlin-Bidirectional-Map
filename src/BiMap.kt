class BiMap<K, T> {
    var map: Map<K, T> = emptyMap()
    var inverseMap: Map<T, K> = emptyMap()
    // Empty Constructor
    constructor()
    // Convert arrays to bidirectional map
    constructor(array: Array<K>, inverseArray: Array<T>) {
        this.map = arrayMapOf(array, inverseArray)
        this.inverseMap = arrayMapOfInverse(inverseArray, array)
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
    fun isKeyInMap(key: K): Boolean {return this.map.containsKey(key)}
    fun isValueInMap(value: T): Boolean {return this.inverseMap.containsKey(value)}
    fun getKey(value: T): K { return this.inverseMap.getValue(value) }
    fun getValue(key: K): T { return this.map.getValue(key) }
}