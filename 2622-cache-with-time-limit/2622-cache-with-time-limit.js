var TimeLimitedCache = function() {
    this.cache = new Map(); // Stores key -> { value, timeoutId }
};

/** * @param {number} key JS Question:
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if a un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const exists = this.cache.has(key);
    
    // If it exists, clear its existing expiration timer
    if (exists) {
        clearTimeout(this.cache.get(key).timeoutId);
    }
    
    // Set a new timer to automatically wipe the key upon expiration
    const timeoutId = setTimeout(() => {
        this.cache.delete(key);
    }, duration);
    
    // Save/Overwrite the entry
    this.cache.set(key, { value, timeoutId });
    
    return exists;
};

/** * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if (this.cache.has(key)) {
        return this.cache.get(key).value;
    }
    return -1;
};

/** * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.cache.size;
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // returns false
 * obj.get(1) // returns 42
 * obj.count() // returns 1
 */
