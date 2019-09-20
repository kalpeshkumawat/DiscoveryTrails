package com.app.discoverytrails.cart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LifeViewModel extends ViewModel {


    private MutableLiveData<List<String>> liveDataList;



    LiveData<List<String>> getStaticList(){


        if (liveDataList == null) {

            liveDataList = new MutableLiveData<>();
            setUpList();
        }



        return liveDataList;
    }



    public void setUpList(){

        List<String> stringList = new ArrayList<>();

        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");
        stringList.add("Four");
        stringList.add("Five");
        stringList.add("Six");
        stringList.add("Seven");
        stringList.add("Eight");
        stringList.add("Nine");
        stringList.add("Ten");


        liveDataList.setValue(stringList);

    }

}
