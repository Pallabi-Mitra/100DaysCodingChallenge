class MyHashSet:

    def __init__(self):
        # Using a prime number of buckets to evenly distribute keys
        self.num_buckets = 769
        self.buckets = [[] for _ in range(self.num_buckets)]

    def _hash(self, key: int) -> int:
        # Simple hash function
        return key % self.num_buckets

    def add(self, key: int) -> None:
        bucket_idx = self._hash(key)
        # Only add if the key doesn't already exist to keep uniqueness
        if key not in self.buckets[bucket_idx]:
            self.buckets[bucket_idx].append(key)

    def remove(self, key: int) -> None:
        bucket_idx = self._hash(key)
        if key in self.buckets[bucket_idx]:
            self.buckets[bucket_idx].remove(key)

    def contains(self, key: int) -> bool:
        bucket_idx = self._hash(key)
        return key in self.buckets[bucket_idx]

"""
class ListNode :
    def __init__(self,key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        self.set = [ListNode(0) for i in range(10**4)]

    def add(self, key: int) -> None:
        
        cur = self.set[key % len(self.set)]

        while cur.next:
            if cur.next.key == key:
                return
            cur = cur.next
        cur.next = ListNode(key)

    def remove(self, key: int) -> None:
        
        cur = self.set[key % len(self.set)]

        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next

    def contains(self, key: int) -> bool:
        cur = self.set[key % len(self.set)]

        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return True
            cur = cur.next
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
"""