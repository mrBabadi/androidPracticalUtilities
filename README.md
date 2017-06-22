# android Practical Utilities

This library contains the most useful and practical Android utilities. if you have any question or suggestion you'r welcome to tell me.


## Usage


### SharedPrefManager class
you can save or retrieve your data easily, by just pass the context, your values (String, int, Long,..), and of course your data KEY to this class.

the most useful feature in this class is that you can also save or retrieve your **Objects**.

### example for SharedPrefHelper

```
//for saving and retrieving a value you can easily do this : 

SharedPrefHelper.setSharedPrefFloat(ctx, key, floatValue);

SharedPrefHelper.getSharedPrefFloat(ctx,key);

// and for other types are the same.

//but for saving an object : 

Student std = new Student();
std.setName("Ali");
std.setFamily("Babadi");

//to save an object
SharedPrefManager.setSharedPrefObject(ctx, key, std);

//to retrieve that object
Student stdRetrieved = (Student)SharedPrefManager.getSharedPrefObject(ctx, key, Student.class);

stdRetrieved.getName();
stdRetrieved.getFamily();
```

## Warning
please notice that for saving an object to sharedPreferences ***you have to add Gson Library in your project***.
<a href= "https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization">Gson Library</a>

## CustomProgressDialog

