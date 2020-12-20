package modeldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;
import modelbean.UserBean;

public class UserDao {

	
	public void doSave(UserBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO Cliente" +
				" (username, email, active, cf, password) VALUES (?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, bean.getUsername());
			preparedStatement.setString(2, bean.getEmail());
			preparedStatement.setBoolean(3, bean.isActive());
			preparedStatement.setString(4, bean.getCf());
			preparedStatement.setString(5, bean.getPassword());
			
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

	
	public void doUpdate(UserBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE Cliente SET " +
				" username = ?, nome = ?, cognome = ?, cf = ?, password = ?,email=? WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);	
			
			preparedStatement.setString(1, bean.getUsername());
			preparedStatement.setString(2, bean.getNome());
			preparedStatement.setString(3, bean.getCognome());
			preparedStatement.setString(4, bean.getCf());
			preparedStatement.setString(5, bean.getPassword());
			preparedStatement.setString(6, bean.getEmail());
			
			preparedStatement.setInt(7, bean.getId());
			
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

	
	public void doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM Cliente WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			
			preparedStatement.setInt(1, id);
			
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

	
	public UserBean doRetrieveById(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UserBean bean = new UserBean();
		
		String selectSQL = "SELECT * FROM Cliente WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setTipo(rs.getBoolean("tipo"));
				bean.setActive(rs.getBoolean("active"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCf(rs.getString("cf"));
				
				
				return bean;
			}			
			
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
			
		
		
	}

	
	public Collection<UserBean> doRetrieveAll(String collection) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<UserBean> products = new ArrayList<UserBean>();
		
		String selectSQL = "SELECT * FROM Cliente";
		
		if(collection != null && !collection.equals("")) {
			selectSQL += " ORDER BY " + collection;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			System.out.println("doRetrieveAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				UserBean bean = new UserBean();
				
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setTipo(rs.getBoolean("tipo"));
				bean.setActive(rs.getBoolean("active"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCf(rs.getString("cf"));
				bean.setPassword(rs.getString("password"));
				
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
	
	public UserBean doRetrieveByEmailPassword(String email, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UserBean bean = new UserBean();
		
		String selectSQL = "SELECT * FROM Cliente WHERE email = ? AND password = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setTipo(rs.getBoolean("tipo"));
				bean.setActive(rs.getBoolean("active"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCf(rs.getString("cf"));
				
				return bean;
			}			
			
			return null;
			
		} catch(SQLException e) {
		throw new RuntimeException(e);
		}
		
	}
	
	public UserBean doRetrieveByUsername(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UserBean bean = new UserBean();
		
		String selectSQL = "SELECT * FROM Cliente WHERE username = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setTipo(rs.getBoolean("tipo"));
				bean.setActive(rs.getBoolean("active"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCf(rs.getString("cf"));
				
				
				return bean;
			}			
			
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
			
		
		
	}
	
	public UserBean doRetrieveByEmail(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UserBean bean = new UserBean();
		
		String selectSQL = "SELECT * FROM Cliente WHERE email = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setUsername(rs.getString("username"));
				bean.setEmail(rs.getString("email"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setTipo(rs.getBoolean("tipo"));
				bean.setActive(rs.getBoolean("active"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCf(rs.getString("cf"));
				
				
				return bean;
			}			
			
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
			
		
		
	}
	
}
