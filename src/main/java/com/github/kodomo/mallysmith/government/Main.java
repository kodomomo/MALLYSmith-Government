package com.github.kodomo.mallysmith.government;

import com.github.kodomo.mallysmith.government.bean.BeanContainer;
import com.github.kodomo.mallysmith.government.database.repository.publicservant.PublicServantRepository;
import com.github.kodomo.mallysmith.government.stub.bank.BankGrpcStub;
import com.github.kodomo.mallysmith.government.stub.user.UserGrpcStub;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        setup();
        GrpcServer server = new GrpcServer(8888);
        server.start();
        server.blockUntilShutdown();
    }

    private static void setup() {
        BeanContainer.registerBean(UserGrpcStub.class);
        BeanContainer.registerBean(BankGrpcStub.class);
        BeanContainer.registerBean(PublicServantRepository.class);
    }

}
