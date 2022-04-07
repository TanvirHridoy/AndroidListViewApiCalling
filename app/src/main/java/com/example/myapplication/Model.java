package com.example.myapplication;


import java.util.ArrayList;

public class Model {
     float page;
     float per_page;
     float total;

    public ArrayList<Model.data> getData() {
        return data;
    }

    public void setData(ArrayList<Model.data> data) {
        this.data = data;
    }

    float total_pages;
    ArrayList<data> data = new ArrayList<data>();
    public class data {
        private float id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;


        // Getter Methods

        public float getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getAvatar() {
            return avatar;
        }

        // Setter Methods

        public void setId( float id ) {
            this.id = id;
        }

        public void setEmail( String email ) {
            this.email = email;
        }

        public void setFirst_name( String first_name ) {
            this.first_name = first_name;
        }

        public void setLast_name( String last_name ) {
            this.last_name = last_name;
        }

        public void setAvatar( String avatar ) {
            this.avatar = avatar;
        }
    }

    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getPer_page() {
        return per_page;
    }

    public float getTotal() {
        return total;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    // Setter Methods

    public void setPage( float page ) {
        this.page = page;
    }

    public void setPer_page( float per_page ) {
        this.per_page = per_page;
    }

    public void setTotal( float total ) {
        this.total = total;
    }

    public void setTotal_pages( float total_pages ) {
        this.total_pages = total_pages;
    }
}