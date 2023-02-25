<div align="center">
<img src="ez-databinding-recyclerview.png" alt="logo" width="512" height="128" />
  <!--<h1>EZ DataBiding / ViewBiding RecyclerView Adapter :D</h1>-->
  <p>A simple adapter to easily implement data and view binding to your Recylerviews</p>
</div>

<br />

<!-- About the Project -->

## :star2: About the Project

Sometime after data/view biding were introduced, I was still using custom view holder and  findViewById() in my recylcerviews, which not only adds a lot of boilerplate but also makes changing things around troublesome. so i looked around and found a medium article about how to Integrate databinding into your project, this library is me improving and building upon that idea.

<!-- Getting Started -->

## :toolbox: Getting Started

````groovy
implementation 'com.github.MansourM:ez-databinding-recyclerview:{$version_here}'
````


<!-- Usage -->

## :eyes: Usage

create you adapter

```Java
public class TestAdapter extends DataBindingRecyclerViewAdapter<Person, ItemPersonBinding> {


  public TestAdapter(ArrayList<Person> personnel) {
    super(personnel);
  }

  @Override
  public void onBindViewHolder(DataBindingViewHolder<ItemPersonBinding> holder, int position) {
    super.onBindViewHolder(holder, position);
    //Do stuff here
    holder.getBinding().tvAge.setOnClickListener(view -> {
      Toast.makeText(view.getContext(), "age", Toast.LENGTH_LONG).show();
    });
    //Example for binding multiple objects
    holder.bind(BR.index, position + 1, false);
    holder.bind(BR.person, getObjForPosition(position));
  }

  @Override
  protected int getLayoutIdForPosition(int position) {
    return R.layout.item_person;
  }
}
```

item_person.xml

```XML
<?xml version="1.0" encoding="utf-8"?>
<layout>

    <data>
        <variable
            name="person"
            type="ir.masterz.mansour.ez.databinding.recyclerview.example.Person" />
        <variable
            name="index"
            type="int" />
    </data>

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:background="@color/purple_200"
        android:layout_marginBottom="3dp"
        android:orientation="horizontal">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingHorizontal="10dp"
            android:text="@{String.valueOf(index)}" />

        <TextView
            android:id="@+id/tv_name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:paddingLeft="10dp"
            android:layout_weight="1"
            android:text="@{person.name}" />

        <TextView
            android:id="@+id/tv_age"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingHorizontal="10dp"
            android:text="@{String.valueOf(person.age)}" />

    </LinearLayout>
</layout>
````

<!-- Roadmap -->

## :compass: Changes from Parent / Roadmap

* [x] databinding.
* [x] viewbinding.
* [x] allow binding more then 1 object.
* [ ] better support for different viewtypes
* [ ] better comments/docs

<!-- Known Issues -->

## :warning: Known Issues


<!-- Contributing -->

## :wave: Contributing

Contributions are always welcome!

<!-- License -->

## :warning: License

Distributed under the GNU GPL V2 License.


<!-- Contact -->

## :handshake: Contact

Seyed Mansour Mirbehbahani - sm.mirbehbahani@gmail.com

<!-- Acknowledgments -->

## :gem: Acknowledgements

- [Android Data Binding: RecyclerView](https://medium.com/androiddevelopers/android-data-binding-recyclerview-db7c40d9f0e4)