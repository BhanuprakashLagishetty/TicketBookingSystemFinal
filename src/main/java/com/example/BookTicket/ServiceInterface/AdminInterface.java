package com.example.BookTicket.ServiceInterface;

import com.example.BookTicket.Entity.Stations;
import com.example.BookTicket.Entity.Train;
import com.example.BookTicket.Models.AdminModel;
import com.example.BookTicket.Models.PriceGenerationModel;
import com.example.BookTicket.Models.SeatsModel;
import com.example.BookTicket.Models.TrainModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public interface AdminInterface {
    String addTrain(TrainModel trainModel);

    void removeTrain(Long id);

    List<TrainModel> displayAllTrains();

    Train addingTicketsToTrain(Long trainId, SeatsModel seatsModel);

    String addingStationsToTrain(Long trainId, Stations stations);

    Set<SeatsModel> displayTrainTickets(Long trainId);

    Set<Stations> DisplayIntermediateStations(Long trainId);

    boolean checkAdminLogin(AdminModel adminModel);

    //used to search for killo meters
    PriceGenerationModel findKilometers(String arrivalStation, String departureStation, @NotNull List<TrainModel> trainModelList);
}
