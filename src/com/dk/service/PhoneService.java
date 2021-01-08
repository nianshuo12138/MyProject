package com.dk.service;

import com.dk.dao.PhoneDao;
import com.dk.domain.PageBean;
import com.dk.domain.Phone;

import java.util.List;

public class PhoneService {
    PhoneDao pd = new PhoneDao();
    public List<Phone> getPhoneInfo(PageBean pb) {
        return pd.getPhoneInfo(pb);

    }

    public int addIt(Phone p) {
        return pd.addIt(p);
    }

    public int deleteIt(String pid) {
        return pd.deleteIt(pid);
    }

    public Phone updateShow(String pid) {
        return pd.updateShow(pid);
    }

    public int updateIt(Phone p) {
        return pd.updateIt(p);
    }

    public int deleteSome(String pids) {

        return pd.deleteSome(pids);
    }

    public int getPhoneCount() {
        return pd.getPhoneCount();
    }
}
