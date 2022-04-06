package com.codegym.service.Impl;

import com.codegym.model.Mailbox;
import com.codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MailboxService implements IMailboxService {
    private static final Map<Integer , Mailbox> mailboxList;

    static {
        mailboxList = new HashMap<>();
        mailboxList.put(1,new Mailbox(1,"ngoc123@gmail.com","Vietnamese",10,true,"Ngoc Tran"));
        mailboxList.put(2,new Mailbox(2,"xiukoi456@gmai.com","Japanese",5,false,"Xiu Nguyen"));
//        languegesList = Arrays.asList("Vietnamese","Japanese","English","Chinese");
    }


    @Override
    public List<Mailbox> findAll() {
        return new ArrayList<>(mailboxList.values());
    }

    @Override
    public void create(Mailbox mailbox) {
        mailboxList.put(mailbox.getId(), mailbox);
    }

    @Override
    public void save(Mailbox mailbox) {
        mailboxList.put(mailbox.getId(), mailbox);
    }
}
