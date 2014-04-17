task4java
=========

task4java is a framework to compose and execute code asynchronously. Its features are:

* lightweight
* high performance
* based on standard Java libraries (Java V1.6 and above)
* Android compatible
* Lambda compatible (Java V1.8)

The key concept is based on JS promises (e.g. [when.js](https://github.com/cujojs/when)) or [Microsoft .NET Task Parallel Library (TPL)](http://msdn.microsoft.com/de-de/library/dd460717(v=vs.110).aspx). 

Usage
-----

```Java
Task<String> taskResult = TaskFactory.startNew(new Callable<String>() {

	@Override
	public String call() throws Exception {

		// Schedule a new task on the default thread pool
		Logger.instance.d(TAG, "Thread for task1: " + Thread.currentThread().getId());

		Thread.sleep(1000);

		return "Ready";
	}
}).continueWith(new CallableTask<String, String>() {

	@Override
	public String call(Task<String> task) throws Exception {

		// Execute this code after the previous task has finished
		Logger.instance.d(TAG, "Thread for step1: " + Thread.currentThread().getId());

		return task.get() + " step1";
	}
}).continueWith(new CallableTask<String, String>() {

	@Override
	public String call(Task<String> task) throws Exception {

		// Execute this code after the previous task has finished
		Logger.instance.d(TAG, "Thread for step2: " + Thread.currentThread().getId());

		return task.get() + " step2";
	}
});

// blocks until the result is available
System.out.println(taskResult.get());
```Java

License
-------

Licensed under Apache license 2.0. [Full license here &raquo;](LICENSE)