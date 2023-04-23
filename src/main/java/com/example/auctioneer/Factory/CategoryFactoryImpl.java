package com.example.auctioneer.Factory;

import com.example.auctioneer.Model.Auction;
import com.example.auctioneer.Service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class CategoryFactoryImpl implements CategoryFactory{

    @Autowired
    AuctionService auctionService;

    @Override
    public Page<Auction> getAllByCategory(String category, PageRequest page) {
        Long id = (long)1;
        if(category.equals("vehicles")){
            id = (long)1;
        }
        if(category.equals("Antique")){
            id = (long)2;
        }
        if(category.equals("electronics")){
            id = (long)3;
        }
        if(category.equals("clothes")){
            id = (long)4;
        }
        return auctionService.findAllByCategoryIdDateAsc(id, page);
    }

    @Override
    public String getTitle(String category) {
        String title = "Unknown category";
        if(category.equals("vehicles")){
            title = "Vehicles";
        }
        if(category.equals("Antique")){
            title = "Antic Items";
        }
        if(category.equals("electronics")){
            title = "Electronics";
        }
        if(category.equals("clothes")){
            title = "Clothes & Accessories";
        }
        return title;
    }
}
