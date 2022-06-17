package ru.irinavb.parks.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.irinavb.parks.model.Park;

public class ParkViewModel extends ViewModel {
   private final MutableLiveData<Park> selectedPark = new MutableLiveData<>();
   private final MutableLiveData<List<Park>> selectedParks = new MutableLiveData<>();

   public void setSelectedPark(Park park) {
      selectedPark.setValue(park);
   }

   public LiveData<Park> getSelectedPark() {
      return selectedPark;
   }

   public void setSelectedParks(List<Park> parks) {
      selectedParks.setValue(parks);
   }

   public LiveData<List<Park>> getSelectedParks() {
      return selectedParks;
   }

}
