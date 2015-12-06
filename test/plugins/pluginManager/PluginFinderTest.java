package plugins.pluginManager;

import static org.junit.Assert.*;

import org.junit.Test;

public class PluginFinderTest {
	
	@Test
	public void registerAndUnregisterObserverTest() {
		MockPluginObserver mockPluginObserver = new MockPluginObserver();
		PluginFinder pluginFinder = new PluginFinder(null);
		
		assertFalse(pluginFinder.getObservers().contains(mockPluginObserver));
		pluginFinder.registerObserver(mockPluginObserver);
		assertTrue(pluginFinder.getObservers().contains(mockPluginObserver));
		pluginFinder.unregisterObserver(mockPluginObserver);
		assertFalse(pluginFinder.getObservers().contains(mockPluginObserver));
	}
	
	@Test
	public void notifyObserversTest() {
		MockPluginObserver[] mocksPluginObserver = new MockPluginObserver[10];
		PluginFinder pluginFinder = new PluginFinder(null);
		
		for(int i = 0;i < mocksPluginObserver.length; i++) {
			mocksPluginObserver[i] = new MockPluginObserver();
		}
		
		for(MockPluginObserver mock : mocksPluginObserver) {
			pluginFinder.registerObserver(mock);
		}
		
		pluginFinder.notifyObservers(null);
		
		for(MockPluginObserver mock : mocksPluginObserver) {
			assertTrue(mock.hasBeenUpdated());
		}
	}

}
