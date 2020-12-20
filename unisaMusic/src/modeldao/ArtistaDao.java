package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import model.DriverManagerConnectionPool;
import modelbean.ArtistaBean;


public class ArtistaDao {

	
	public void doSave(ArtistaBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO Artista" +
				" (nome_arte) VALUES (?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, bean.getNomeArte());
			//preparedStatement.setLong(2, bean.getNumeroBrani());

			
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

	public void doUpdate(ArtistaBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE Artista SET " +
				" nome_arte = ?, numero_brani = ? WHERE nome_arte = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);	
			
			preparedStatement.setString(1, bean.getNomeArte());
			preparedStatement.setLong(2, bean.getNumeroBrani());
			
			
			preparedStatement.setString(1, bean.getNomeArte());
			
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

	
	public void doDelete(ArtistaBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM Artista WHERE nome_arte = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			
			preparedStatement.setString(1, bean.getNomeArte());
			
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

	
	public ArtistaBean doRetrieveById(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArtistaBean bean = new ArtistaBean();
		
		String selectSQL = "SELECT * FROM Artista WHERE nome_arte = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				bean.setNomeArte(rs.getString("nome_arte"));

					
				return bean;
			}			
			
			
			return null;
			
		} catch(SQLException e) {
		throw new RuntimeException(e);
		}
		
		
		}

	
	public ArrayList<ArtistaBean> doRetrieveAll(String collection) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<ArtistaBean> products = new ArrayList<ArtistaBean>();
		
		String selectSQL = "SELECT * FROM Artista";
		
		if(collection != null && !collection.equals("")) {
			selectSQL += " ORDER BY " + collection + " desc LIMIT "+10;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ArtistaBean bean = new ArtistaBean();
				bean.setNomeArte(rs.getString("nome_arte"));
				bean.setNumeroBrani(rs.getInt("numero_brani"));
				bean.setAscolti(rs.getInt("ascolti"));
				
				products.add(bean);
			}
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return products;
	}

}
