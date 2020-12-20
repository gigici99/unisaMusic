package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import modelbean.CanzoniAcquistateBean;

public class CanzoniAcquistateDao {
	public void doSave(CanzoniAcquistateBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO canzoniAcquistate" +
				" (idCliente, idBrano) VALUES (?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setInt(1, bean.getIdCliente());
			preparedStatement.setInt(2, bean.getIdBrano());
			
			
			preparedStatement.executeUpdate();
		
			connection.commit();

		} finally {
				try {
					if(preparedStatement != null) 
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}		
		
	}
	
	public ArrayList<CanzoniAcquistateBean> doRetrieveByIdCliente(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		ArrayList<CanzoniAcquistateBean> canzoni = new ArrayList<CanzoniAcquistateBean>();
		
		String selectSQL = "SELECT * FROM canzoniAcquistate WHERE idCliente = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				CanzoniAcquistateBean bean = new CanzoniAcquistateBean();
				bean.setIdCliente(rs.getInt("idCliente"));
				bean.setIdBrano(rs.getInt("idBrano"));
				
				canzoni.add(bean);
			}			
			
			return canzoni;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public boolean doRetrieveByAcquista(int idCliente, int idBrano) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		String selectSQL = "SELECT * FROM canzoniAcquistate WHERE idCliente = ? and idBrano = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idCliente);
			preparedStatement.setInt(2, idBrano);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return true;
				}			
			
			return false;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
