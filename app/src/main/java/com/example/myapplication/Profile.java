package com.example.myapplication;

public class Profile {
  private String name;
  private String description;
  private String price;
  private String profilePic;
  private boolean permission;

    public Profile() {
    }

    public Profile(String name, String description, String price, String profilePic, boolean permission) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.profilePic = profilePic;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
