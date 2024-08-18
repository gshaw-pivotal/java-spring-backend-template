package com.gs.backend_template.database;

import com.gs.backend_template.model.Foo;

import java.sql.*;

public class H2FooRepository implements FooRepository {

    private String dbUrl;

    private String dbUser;

    private String dbPass;

    private final String insertFoo = "insert into foo (desc) values ('%s')";

    private final String updateFoo = "update foo set desc = '%s' where id = %s";

    private final String queryForFoo = "select * from foo where id = %s";

    private final String deleteFoo = "delete from foo where id = %s";

    private final String getLastId = "select max(id) from foo";

    public H2FooRepository(String dbUrl, String dbUser, String dbPass) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    @Override
    public Foo addFoo(Foo foo) {
        try {
            Foo resultFoo = null;

            Connection conn = getConnection();

            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(String.format(insertFoo, foo.getDesc()));

                ResultSet rs = stmt.executeQuery(getLastId);

                if (rs.next()) {
                    resultFoo = getFoo(rs.getInt(1));
                }

                conn.close();

                return resultFoo;
            }
        } catch (SQLException e) {
            return null;
        }

        return null;
    }

    @Override
    public Foo deleteFoo(int id) {
        try {
            Foo resultFoo = null;

            Connection conn = getConnection();

            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(String.format(deleteFoo, id));

                if (rs.next()) {
                    resultFoo = Foo.builder().id(rs.getInt(1)).desc(rs.getString(2)).build();
                }

                conn.close();

                return resultFoo;
            }
        } catch (SQLException e) {
            return null;
        }

        return null;
    }

    @Override
    public Foo updateFoo(int id, Foo foo) {
        try {
            Foo resultFoo = null;

            Connection conn = getConnection();

            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(String.format(updateFoo, foo.getDesc(), id));

                resultFoo = getFoo(id);

                conn.close();

                return resultFoo;
            }
        } catch (SQLException e) {
            return null;
        }

        return null;
    }

    @Override
    public Foo getFoo(int id) {
        try {
            Foo resultFoo = null;

            Connection conn = getConnection();

            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(String.format(queryForFoo, id));

                if (rs.next()) {
                    resultFoo = Foo.builder().id(rs.getInt(1)).desc(rs.getString(2)).build();
                }

                conn.close();

                return resultFoo;
            }
        } catch (SQLException e) {
            return null;
        }

        return null;
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    dbUrl, dbUser, dbPass
            );
        } catch (SQLException e) {
            return null;

        }
    }
}
