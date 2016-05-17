# Cache tester portlet

This is create as example how to use Liferay's caches. Liferay has two cache zones SingleVm and MultiVM. Basically SingleVM is node wide and MultiVM is cluster wide.

- SingleVM should be used when Liferay's cluster node's does not have information when the expire cache.
- MultiVM should be used when node's are updating data or some other reason can tell other node to remove keys or flust whole cache.

## Build

```.bash
mvn install
```
Deploy resulted war file to Liferay's deploy directory
