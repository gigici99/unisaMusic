package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.DriverManagerConnectionPool;
import modelbean.BranoBean;

public class BranoDao {

	
	public void doSave(BranoBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO Brano" +
				" (titolo, durata, nome_arte) VALUES (?, ?, ?)";
		
	
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, bean.getTitle());
			preparedStatement.setString(2, bean.getTime());
			preparedStatement.setString(3, bean.getNomeArtista());
			
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

	public void doUpdate(BranoBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE Brano SET " +
				" titolo = ?, durata = ?, nome_arte = ?, ascolti = ? WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);	
			
			preparedStatement.setString(1, bean.getTitle());
			preparedStatement.setString(2, bean.getTime());
			preparedStatement.setString(3, bean.getNomeArtista());
			preparedStatement.setInt(4, (int) bean.getAscolti());
			
			preparedStatement.setLong(5, bean.getID());
			
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

	
	public void doDelete(BranoBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM Brano WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			
			preparedStatement.setLong(1, bean.getID());
			
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

	
	public BranoBean doRetrieveById(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		BranoBean bean = new BranoBean();
		
		String selectSQL = "SELECT * FROM Brano WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				bean.setID(rs.getInt("id"));
				bean.setTitle(rs.getString("titolo"));
				bean.setTime(rs.getString("durata"));
				bean.setNomeArtista(rs.getString("nome_arte"));
				bean.setAscolti(rs.getInt("ascolti"));
				
				return bean;
			}			
			
			
			return null;
			
		} catch(SQLException e) {
		throw new RuntimeException(e);
		}
		
		
		}

	
	public ArrayList<BranoBean> doRetrieveAll(String collection) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<BranoBean> products = new ArrayList<BranoBean>();
		
		String selectSQL = "SELECT * FROM Brano";
		
		if(collection != null && !collection.equals("")) {
			selectSQL += " ORDER BY " + collection + " desc LIMIT "+10;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				BranoBean bean = new BranoBean();
				bean.setID(rs.getInt("id"));
				bean.setTitle(rs.getString("titolo"));
				bean.setTime(rs.getString("durata"));
				bean.setNomeArtista(rs.getString("nome_arte"));		
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
	
	public ArrayList<BranoBean> doRetrieveByNome(String query) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<BranoBean> products = new ArrayList<BranoBean>();
		
		String selectSQL = "SELECT * FROM Brano WHERE MATCH(titolo) AGAINST(? IN BOOLEAN MODE)";
		
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				BranoBean bean = new BranoBean();
				bean.setID(rs.getInt("id"));
				bean.setTitle(rs.getString("titolo"));
				bean.setTime(rs.getString("durata"));
				bean.setNomeArtista(rs.getString("nome_arte"));		
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
