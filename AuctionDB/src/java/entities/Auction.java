/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sathiesh
 */
@Entity
@Table(name = "auction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auction.findAll", query = "SELECT a FROM Auction a")
    , @NamedQuery(name = "Auction.findById", query = "SELECT a FROM Auction a WHERE a.id = :id")
    , @NamedQuery(name = "Auction.findByAuctionname", query = "SELECT a FROM Auction a WHERE a.auctionname = :auctionname")
    , @NamedQuery(name = "Auction.findByCategory", query = "SELECT a FROM Auction a WHERE a.category = :category")
    , @NamedQuery(name = "Auction.findByCategorytype", query = "SELECT a FROM Auction a WHERE a.categorytype = :categorytype")
    , @NamedQuery(name = "Auction.findByDescription", query = "SELECT a FROM Auction a WHERE a.description = :description")
    , @NamedQuery(name = "Auction.findByFinished", query = "SELECT a FROM Auction a WHERE a.finished = :finished")
    , @NamedQuery(name = "Auction.findByRating", query = "SELECT a FROM Auction a WHERE a.rating = :rating")
    , @NamedQuery(name = "Auction.findByStatus", query = "SELECT a FROM Auction a WHERE a.status = :status")
    , @NamedQuery(name = "Auction.findByTimecreated", query = "SELECT a FROM Auction a WHERE a.timecreated = :timecreated")})
public class Auction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "auctionname")
    private String auctionname;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Column(name = "categorytype")
    private Integer categorytype;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "finished")
    private Boolean finished;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Double rating;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "timecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timecreated;
    @JoinColumn(name = "auctionowner_id", referencedColumnName = "id")
    @ManyToOne
    private Appuser auctionownerId;

    public Auction() {
    }

    public Auction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuctionname() {
        return auctionname;
    }

    public void setAuctionname(String auctionname) {
        this.auctionname = auctionname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(Integer categorytype) {
        this.categorytype = categorytype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Date timecreated) {
        this.timecreated = timecreated;
    }

    public Appuser getAuctionownerId() {
        return auctionownerId;
    }

    public void setAuctionownerId(Appuser auctionownerId) {
        this.auctionownerId = auctionownerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Auction[ id=" + id + " ]";
    }
    
}
