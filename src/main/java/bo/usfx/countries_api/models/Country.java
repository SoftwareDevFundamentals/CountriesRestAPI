package bo.usfx.countries_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countries")
public final class Country {
    @Id
    private String id;
    private String name;
    private String area;
    private String capital;
    private String population;
    private String[] cities;
    private String[] languages;
    private String extension;
    private String latitude;
    private String longitude;
    private String currency;
    private String securityLevel;
    private String flag;
    private String codeCountry;
    private String demonym;
    private String typeOfWeather;
    private String economy;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(final String area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(final String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(final String population) {
        this.population = population;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(final String[] cities) {
        this.cities = cities;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(final String[] languages) {
        this.languages = languages;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(final String extension) {
        this.extension = extension;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(final String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(final String flag) {
        this.flag = flag;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(final String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(final String demonym) {
        this.demonym = demonym;
    }

    public String getTypeOfWeather() {
        return typeOfWeather;
    }

    public void setTypeOfWeather(final String typeOfWeather) {
        this.typeOfWeather = typeOfWeather;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(final String economy) {
        this.economy = economy;
    }
}
