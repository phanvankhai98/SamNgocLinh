package com.pvkhaicd.samngoclinh.ViewController.Market;

import com.pvkhaicd.samngoclinh.Model.MarketItem;

import java.util.List;

public interface MarketContact {
    interface View{
        void showPurchaseList(List<MarketItem> items);
        void showSellList(List<MarketItem> items);
        void showGetListError(String message);
    }
    interface Presenter{
        void getPurchaseList();
        void getSellList();
    }
}
