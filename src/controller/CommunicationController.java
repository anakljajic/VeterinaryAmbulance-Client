/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.DomainObject;
import domain.Karton;
import domain.Klijent;
import domain.PoreskaStopa;
import domain.PredmetProdaje;
import domain.Racun;
import domain.Radnik;
import domain.StavkaRacuna;
import domain.Zivotinja;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;

/**
 *
 * @author student1
 */
public class CommunicationController {

    private static CommunicationController instance;
    private Socket socket;

    private CommunicationController() throws IOException {
        socket = new Socket("localhost", 9000);

    }

    public static CommunicationController getInstance() throws IOException {
        if (instance == null) {
            instance = new CommunicationController();
        }
        return instance;
    }

    private void sendRequest(RequestObject request) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(request);
        out.flush();
    }

    private ResponseObject receiveResponse() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ResponseObject response = (ResponseObject) in.readObject();
        return response;
    }

    public List<Radnik> selectAllWorkers() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_WORKERS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Radnik>) response.getData();
    }

    public List<Radnik> searchWorkerWithCriteria(String criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_WORKER_WITH_CRITERIA);
        request.setData(criteria);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Radnik>) response.getData();
    }

    public List<Klijent> selectAllClients() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_CLIENTS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Klijent>) response.getData();
    }

    public List<Zivotinja> searchPetsWithCriteria(String criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_PETS_WITH_CRITERIA);
        request.setData(criteria);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Zivotinja>) response.getData();
    }

    public List<Klijent> searchClientsWithCriteria(String criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_CLIENTS_WITH_CRITERIA);

        request.setData(criteria);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Klijent>) response.getData();
    }

    public List<Karton> searchMedicalRecordsWithCriteria(String criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_MEDICAL_RECORDS_WITH_CRITERIA);

        request.setData(criteria);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Karton>) response.getData();
    }

    public List<Racun> selectAllBillsFromDate(String criteria) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_BILL_WITH_CRITERIA);

        request.setData(criteria);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Racun>) response.getData();
    }

    public List<Karton> selectAllMedicalRecords() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_MEDICAL_RECORDS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Karton>) response.getData();
    }

    public List<PredmetProdaje> selectAllObjectOfSale() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_OBJECT_OF_SALE);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<PredmetProdaje>) response.getData();
    }

    public List<Racun> selectAllBills() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_BILLS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Racun>) response.getData();
    }

    public List<PoreskaStopa> selectAllTaxes() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_TAXES);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<PoreskaStopa>) response.getData();
    }

    public Radnik login(String username, String password) throws IOException, ClassNotFoundException, Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_LOGIN);

        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);
        request.setData(data);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }

        ClientController.getInstance().setRadnik((Radnik) response.getData());

        return (Radnik) response.getData();
    }

    public DomainObject updateDomainObject(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_UPDATE_DOMAIN_OBJECT);

        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return odo;
    }

    public DomainObject setStornoBill(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SET_STORNO_BILL);

        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return odo;
    }

    public List<StavkaRacuna> insertListDomainObject(List<StavkaRacuna> stavke) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_INSERT_LIST_DOMAIN_OBJECT);

        request.setData(stavke);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<StavkaRacuna>) response.getData();
    }

    public DomainObject insertDomainObject(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_INSERT_DOMAIN_OBJECT);

        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (DomainObject) response.getData();
    }

    public DomainObject generateDomainObject(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_GENERATE_DOMAIN_OBJECT);
        request.setData(odo);

        sendRequest(request);
        ResponseObject response = receiveResponse();
        odo = (DomainObject) response.getData();

        if (response.getException() != null) {
            throw response.getException();
        }

        return odo;
    }

    public List<Zivotinja> searchClientsPet(Long id) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SEARCH_CLIENTS_PET);
        request.setData(id);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Zivotinja>) response.getData();
    }

    public List<Zivotinja> selectAllPets() throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SELECT_ALL_PETS);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Zivotinja>) response.getData();
    }

    public void deleteObject(DomainObject odo) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_DELETE_DOMAIN_OBJECT);
        request.setData(odo);
        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public Racun saveBillWithItems(Racun racun) throws Exception {
        RequestObject request = new RequestObject();
        request.setOperation(Operation.OPERATION_SAVE_BILL_AND_BILL_ITEMS);

        request.setData(racun);

        sendRequest(request);
        ResponseObject response = receiveResponse();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (Racun) response.getData();
    }

}
