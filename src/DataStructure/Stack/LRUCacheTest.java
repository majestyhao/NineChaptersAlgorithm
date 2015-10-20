package DataStructure.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
	LRUCache lru = new LRUCache(3);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet() {
		lru.set(1,1);
		lru.set(2,2);
		lru.set(3,3);
		lru.set(4,4);
		assertEquals(4, lru.get(4));
		assertEquals(3, lru.get(3));
		assertEquals(2, lru.get(2));
		assertEquals(-1, lru.get(1));
		
		lru = new LRUCache(1);
		lru.set(2,1);
		lru.get(2);
		lru.set(3,2);
		lru.get(2);
		lru.get(3);
		
		//set(5,5),get(1),get(2),get(3),get(4),get(5)]
	}


}
