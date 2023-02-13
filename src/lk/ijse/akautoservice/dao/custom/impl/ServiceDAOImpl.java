package lk.ijse.akautoservice.dao.custom.impl;

import lk.ijse.akautoservice.dao.CrudDAO;
import lk.ijse.akautoservice.dao.custom.ServiceDAO;
import lk.ijse.akautoservice.dto.ServicePackageDTO;
import lk.ijse.akautoservice.entity.ServicePackage;
import lk.ijse.akautoservice.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDAOImpl implements ServiceDAO {
    @Override
    public boolean save(ServicePackage servicePackageDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Update(ServicePackage r) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<ServicePackage> search(String x) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String x) throws SQLException, ClassNotFoundException {
        return false;
    }

    public  ArrayList<ServicePackage> showAllData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Service_package;");
        ArrayList<ServicePackage> slist = new ArrayList<>();

        while (result.next()) {
            ServicePackage servicePackage = new ServicePackage(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getDouble(4)

            );
            slist.add(servicePackage);
        }
        return slist;


    }

}
