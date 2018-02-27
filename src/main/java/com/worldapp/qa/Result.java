package com.worldapp.qa;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isGameCenterEnabled",
        "ipadScreenshotUrls",
        "appletvScreenshotUrls",
        "artworkUrl60",
        "artworkUrl512",
        "artworkUrl100",
        "artistViewUrl",
        "advisories",
        "supportedDevices",
        "kind",
        "features",
        "screenshotUrls",
        "trackCensoredName",
        "languageCodesISO2A",
        "fileSizeBytes",
        "sellerUrl",
        "contentAdvisoryRating",
        "trackViewUrl",
        "trackContentRating",
        "genreIds",
        "currentVersionReleaseDate",
        "trackId",
        "trackName",
        "minimumOsVersion",
        "currency",
        "wrapperType",
        "version",
        "artistId",
        "artistName",
        "genres",
        "price",
        "description",
        "bundleId",
        "isVppDeviceBasedLicensingEnabled",
        "releaseDate",
        "formattedPrice",
        "sellerName",
        "primaryGenreId",
        "releaseNotes",
        "primaryGenreName"
})
public class Result {

    @JsonProperty("isGameCenterEnabled")
    private boolean isGameCenterEnabled;
    @JsonProperty("ipadScreenshotUrls")
    private List<String> ipadScreenshotUrls = null;
    @JsonProperty("appletvScreenshotUrls")
    private List<Object> appletvScreenshotUrls = null;
    @JsonProperty("artworkUrl60")
    private String artworkUrl60;
    @JsonProperty("artworkUrl512")
    private String artworkUrl512;
    @JsonProperty("artworkUrl100")
    private String artworkUrl100;
    @JsonProperty("artistViewUrl")
    private String artistViewUrl;
    @JsonProperty("advisories")
    private List<Object> advisories = null;
    @JsonProperty("supportedDevices")
    private List<String> supportedDevices = null;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("features")
    private List<String> features = null;
    @JsonProperty("screenshotUrls")
    private List<String> screenshotUrls = null;
    @JsonProperty("trackCensoredName")
    private String trackCensoredName;
    @JsonProperty("languageCodesISO2A")
    private List<String> languageCodesISO2A = null;
    @JsonProperty("fileSizeBytes")
    private String fileSizeBytes;
    @JsonProperty("sellerUrl")
    private String sellerUrl;
    @JsonProperty("contentAdvisoryRating")
    private String contentAdvisoryRating;
    @JsonProperty("trackViewUrl")
    private String trackViewUrl;
    @JsonProperty("trackContentRating")
    private String trackContentRating;
    @JsonProperty("genreIds")
    private List<String> genreIds = null;
    @JsonProperty("currentVersionReleaseDate")
    private String currentVersionReleaseDate;
    @JsonProperty("trackId")
    private long trackId;
    @JsonProperty("trackName")
    private String trackName;
    @JsonProperty("minimumOsVersion")
    private String minimumOsVersion;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("wrapperType")
    private String wrapperType;
    @JsonProperty("version")
    private String version;
    @JsonProperty("artistId")
    private long artistId;
    @JsonProperty("artistName")
    private String artistName;
    @JsonProperty("genres")
    private List<String> genres = null;
    @JsonProperty("price")
    private double price;
    @JsonProperty("description")
    private String description;
    @JsonProperty("bundleId")
    private String bundleId;
    @JsonProperty("isVppDeviceBasedLicensingEnabled")
    private boolean isVppDeviceBasedLicensingEnabled;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("formattedPrice")
    private String formattedPrice;
    @JsonProperty("sellerName")
    private String sellerName;
    @JsonProperty("primaryGenreId")
    private long primaryGenreId;
    @JsonProperty("releaseNotes")
    private String releaseNotes;
    @JsonProperty("primaryGenreName")
    private String primaryGenreName;

    @JsonProperty("isGameCenterEnabled")
    public boolean isIsGameCenterEnabled() {
        return isGameCenterEnabled;
    }

    @JsonProperty("isGameCenterEnabled")
    public void setIsGameCenterEnabled(boolean isGameCenterEnabled) {
        this.isGameCenterEnabled = isGameCenterEnabled;
    }

    @JsonProperty("ipadScreenshotUrls")
    public List<String> getIpadScreenshotUrls() {
        return ipadScreenshotUrls;
    }

    @JsonProperty("ipadScreenshotUrls")
    public void setIpadScreenshotUrls(List<String> ipadScreenshotUrls) {
        this.ipadScreenshotUrls = ipadScreenshotUrls;
    }

    @JsonProperty("appletvScreenshotUrls")
    public List<Object> getAppletvScreenshotUrls() {
        return appletvScreenshotUrls;
    }

    @JsonProperty("appletvScreenshotUrls")
    public void setAppletvScreenshotUrls(List<Object> appletvScreenshotUrls) {
        this.appletvScreenshotUrls = appletvScreenshotUrls;
    }

    @JsonProperty("artworkUrl60")
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    @JsonProperty("artworkUrl60")
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    @JsonProperty("artworkUrl512")
    public String getArtworkUrl512() {
        return artworkUrl512;
    }

    @JsonProperty("artworkUrl512")
    public void setArtworkUrl512(String artworkUrl512) {
        this.artworkUrl512 = artworkUrl512;
    }

    @JsonProperty("artworkUrl100")
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    @JsonProperty("artworkUrl100")
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    @JsonProperty("artistViewUrl")
    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    @JsonProperty("artistViewUrl")
    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    @JsonProperty("advisories")
    public List<Object> getAdvisories() {
        return advisories;
    }

    @JsonProperty("advisories")
    public void setAdvisories(List<Object> advisories) {
        this.advisories = advisories;
    }

    @JsonProperty("supportedDevices")
    public List<String> getSupportedDevices() {
        return supportedDevices;
    }

    @JsonProperty("supportedDevices")
    public void setSupportedDevices(List<String> supportedDevices) {
        this.supportedDevices = supportedDevices;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("features")
    public List<String> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @JsonProperty("screenshotUrls")
    public List<String> getScreenshotUrls() {
        return screenshotUrls;
    }

    @JsonProperty("screenshotUrls")
    public void setScreenshotUrls(List<String> screenshotUrls) {
        this.screenshotUrls = screenshotUrls;
    }

    @JsonProperty("trackCensoredName")
    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    @JsonProperty("trackCensoredName")
    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    @JsonProperty("languageCodesISO2A")
    public List<String> getLanguageCodesISO2A() {
        return languageCodesISO2A;
    }

    @JsonProperty("languageCodesISO2A")
    public void setLanguageCodesISO2A(List<String> languageCodesISO2A) {
        this.languageCodesISO2A = languageCodesISO2A;
    }

    @JsonProperty("fileSizeBytes")
    public String getFileSizeBytes() {
        return fileSizeBytes;
    }

    @JsonProperty("fileSizeBytes")
    public void setFileSizeBytes(String fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    @JsonProperty("sellerUrl")
    public String getSellerUrl() {
        return sellerUrl;
    }

    @JsonProperty("sellerUrl")
    public void setSellerUrl(String sellerUrl) {
        this.sellerUrl = sellerUrl;
    }

    @JsonProperty("contentAdvisoryRating")
    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    @JsonProperty("contentAdvisoryRating")
    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    @JsonProperty("trackViewUrl")
    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    @JsonProperty("trackViewUrl")
    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    @JsonProperty("trackContentRating")
    public String getTrackContentRating() {
        return trackContentRating;
    }

    @JsonProperty("trackContentRating")
    public void setTrackContentRating(String trackContentRating) {
        this.trackContentRating = trackContentRating;
    }

    @JsonProperty("genreIds")
    public List<String> getGenreIds() {
        return genreIds;
    }

    @JsonProperty("genreIds")
    public void setGenreIds(List<String> genreIds) {
        this.genreIds = genreIds;
    }

    @JsonProperty("currentVersionReleaseDate")
    public String getCurrentVersionReleaseDate() {
        return currentVersionReleaseDate;
    }

    @JsonProperty("currentVersionReleaseDate")
    public void setCurrentVersionReleaseDate(String currentVersionReleaseDate) {
        this.currentVersionReleaseDate = currentVersionReleaseDate;
    }

    @JsonProperty("trackId")
    public long getTrackId() {
        return trackId;
    }

    @JsonProperty("trackId")
    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    @JsonProperty("trackName")
    public String getTrackName() {
        return trackName;
    }

    @JsonProperty("trackName")
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @JsonProperty("minimumOsVersion")
    public String getMinimumOsVersion() {
        return minimumOsVersion;
    }

    @JsonProperty("minimumOsVersion")
    public void setMinimumOsVersion(String minimumOsVersion) {
        this.minimumOsVersion = minimumOsVersion;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("wrapperType")
    public String getWrapperType() {
        return wrapperType;
    }

    @JsonProperty("wrapperType")
    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("artistId")
    public long getArtistId() {
        return artistId;
    }

    @JsonProperty("artistId")
    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    @JsonProperty("artistName")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("artistName")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("bundleId")
    public String getBundleId() {
        return bundleId;
    }

    @JsonProperty("bundleId")
    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    @JsonProperty("isVppDeviceBasedLicensingEnabled")
    public boolean isIsVppDeviceBasedLicensingEnabled() {
        return isVppDeviceBasedLicensingEnabled;
    }

    @JsonProperty("isVppDeviceBasedLicensingEnabled")
    public void setIsVppDeviceBasedLicensingEnabled(boolean isVppDeviceBasedLicensingEnabled) {
        this.isVppDeviceBasedLicensingEnabled = isVppDeviceBasedLicensingEnabled;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("formattedPrice")
    public String getFormattedPrice() {
        return formattedPrice;
    }

    @JsonProperty("formattedPrice")
    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    @JsonProperty("sellerName")
    public String getSellerName() {
        return sellerName;
    }

    @JsonProperty("sellerName")
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @JsonProperty("primaryGenreId")
    public long getPrimaryGenreId() {
        return primaryGenreId;
    }

    @JsonProperty("primaryGenreId")
    public void setPrimaryGenreId(long primaryGenreId) {
        this.primaryGenreId = primaryGenreId;
    }

    @JsonProperty("releaseNotes")
    public String getReleaseNotes() {
        return releaseNotes;
    }

    @JsonProperty("releaseNotes")
    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    @JsonProperty("primaryGenreName")
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    @JsonProperty("primaryGenreName")
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

}