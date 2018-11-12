class BiMap<K, T> {
    private var map: MutableMap<K, T> = mutableMapOf()
    private var inverseMap: MutableMap<T, K> = mutableMapOf()
    // Empty Constructor
    constructor()
    // Convert arrays to bidirectional map
    constructor(array: Array<K>, inverseArray: Array<T>) {
        this.map = arrayMapOf(array, inverseArray)
        this.inverseMap = arrayMapOfInverse(inverseArray, array)
    }
    // Convert array into map
    private fun arrayMapOf(array: Array<K>, inverseArray: Array<T>): MutableMap<K, T> {
        val newMap: MutableMap<K, T> = mutableMapOf()
        val arrayPair = ArrayPair(array, inverseArray, array.size)
        for (itemPair in arrayPair) {
            newMap.put(itemPair.first, itemPair.second)
        }
        return newMap
    }
    // Convert inverse array into map
    private fun arrayMapOfInverse(array: Array<T>, inverseArray: Array<K>): MutableMap<T, K> {
        val newMap: MutableMap<T, K> = mutableMapOf()
        val arrayPair = ArrayPair(array, inverseArray, array.size)
        for (itemPair in arrayPair) {
            newMap.put(itemPair.first, itemPair.second)
        }
        return newMap
    }
    fun add(key: K, value: T) {
        this.map.put(key, value)
        this.inverseMap.put(value, key)
    }
    fun remove(key: K, value: T) {
        this.map.remove(key)
        this.inverseMap.remove(value)
    }
    fun isKeyInMap(key: K): Boolean {return this.map.containsKey(key)}
    fun isValueInMap(value: T): Boolean {return this.inverseMap.containsKey(value)}
    fun getKey(value: T): K { return this.inverseMap.getValue(value) }
    fun getValue(key: K): T { return this.map.getValue(key) }
}