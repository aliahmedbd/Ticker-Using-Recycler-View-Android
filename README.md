# Creating a Autoscrolled RecyclerView like Marquee text in Android also known as "Ticker in android"
 
### Why this article? 
Sometimes in our android apps need a marquee text effect like smooth autoscroll horizontally or vertically. 
##### Example:
For breaking news app there is a most necessary functionality which is show the breaking news like a horizontal scroll.  
Again, In share market app in top app should give a auto scroll effect for show the text. 

Stock exchange scroll: 
![alt text](https://github.com/aliahmedbd/Ticker-Using-Recycler-View-Android/blob/master/ezgif.com-crop.gif "Example Activity")

  
But in android there is no perfect library for marquee text but in this article I will give a simplest solution for marquee text. 
 
### Procedure: 
#### Add RecyclerView: 
Add RecyclerView as your desire place and also add dependency in gradle. 
 
#### XML: 
```xml
<android.support.v7.widget.RecyclerView 
    android:id="@+id/rec_all_stocks" 
    android:layout_width="match_parent" 
    android:layout_height="match_parent" 
    android:scrollbars="vertical" 
    android:layout_alignParentLeft="true" 
    android:layout_alignParentStart="true"></android.support.v7.widget.RecyclerView> 
    
```
#### Gradle :  
```java
compile 'com.android.support:recyclerview-v7:24.2.0' 

```
 
 
#### Create adapter for RecyclerView 
Create adapter for RecyclerView. If you don't know how to create adapter please follow this link: [Click Here](http://antonioleiva.com/recyclerview/ ) 
 
#### Make horizontal scroll 
For RecyclerView we have to use LayoutManager there is a method which is :  

```java
LinearLayoutManager linearLayoutManager = new   LinearLayoutManager(MainActivity.this); 
linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); 
```
Then use this in RecyclerView : 

```java
    yourRecyclerView.setLayoutManager(linearLayoutManager ); 
```
    
Then your RecyclerView will srolled in horizontally. 

#### Creating auto scroll for RecyclerView 
Here I use a thread which will perform autoscroll the items of RecyclerView. There is a method in RecyclerView which is smoothScrollToPosition() which take position of recyclerview to scroll that position to current position. So I use a thread to increment the position automatically so an autoscroll is happening because position is incremented automatically. When all incremented position will equal to the total item size then start from beginning. In this way an autoscroll effect is happened.   
Here is the code :  

```java
public void autoScroll(){ 
    final int speedScroll = 0; 
    final Handler handler = new Handler(); 
     final Runnable runnable = new Runnable() { 
           int count = 0; 
           @Override 
           public void run() { 
           if(count == scrollStockAdapter.getItemCount()) 
           count =0; 
           if(count < scrollStockAdapter.getItemCount()){ 
               rec_scroll_stock.smoothScrollToPosition(++count); 
               handler.postDelayed(this,speedScroll); 
           } 
       } 
    }; 
    handler.postDelayed(runnable,speedScroll); 
} 
```
 
#### Create Smooth scroll automatically 
Now main problem is auto scroll speed which is too fast. For RecyclerView we have to declare a LayoutManager. In LayoutManager  there is a method which is  smoothScrollToPosition() which is responsible for smooth scrolling. But for scrolling there is a velocity which default speed is 25f. To change this velocity you have to override this method. If you want a smooth scroll then increase this value as you want. In my case I use 4000f.  
```java
LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this) { 
    @Override 
    public void smoothScrollToPosition(RecyclerView recyclerView,RecyclerView.State state, int position) { 
    LinearSmoothScroller smoothScroller = newLinearSmoothScroller(MainActivity.this) { 
      private static final float SPEED = 4000f;// Change this value (default=25f) 
      @Override 
      protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) { 
                    return SPEED / displayMetrics.densityDpi; 
          } 
      }; 
      smoothScroller.setTargetPosition(position); 
      startSmoothScroll(smoothScroller); 
      } 
 
};  
```
Then set this LayoutManager to your RecyclerView like this : 
yourRecyclerView.setLayoutManager(layoutManager); 
 
#### Conclusion: 
 In this way you can get a look and feel like Marquee text or like news feed. 
 
 ### Using this repository in your project?
If you are using this repository in your project, and happy about it, please send me a [email](mailto:aliahmedaiub@gmail.com) and let me know, I'll add a references of your app. Thanks :)
 
 
 ## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details. 

