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
please notice that for saving an object to sharedPreferences ***you have to add Gson Library in your project*** , 
and also ***use GsonHelper class*** which i added in this repository **OtherUtilities/GsonHelper.java**.

<a href= "https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization">Gson Library</a>

### GsonHelper (in OtherUtilities Directory)
Singleton Gson easy to use

```
//call .toJson(object) with your object model to convert it To JSON
String json = GsonHelper.toJson();
//call .fromJson() to convert your json To your object model
GsonHelper.fromJson(json,Class<?>);
```

### CustomProgressDialog.class (in ProgressDialog Directory)

create your own custom progress dialog with your view, theme style and text by using this class.
```
//Code Sample
CustomProgressDialog cpd = new CustomProgressDialog(yourContext, yourView, viewWidth, viewHeight);
cpd.setText("please wait...").setTypeFace(YOUR_TYPFACE).setTextColor("#FFF").setTextSize(25).setCancelable(false);
cpd.show();

//you can also pass your own Theme Style to the CustomProgressDialog constructor.
CustomProgressDialog cpd = new CustomProgressDialog(yourContext, R.style.YOUR_STYLE, yourView, viewWidth, viewHeight);
```
#### Result

![alt text](https://github.com/mrBabadi/androidPracticalUtilities/raw/master/custom_progress_dialog.png)
