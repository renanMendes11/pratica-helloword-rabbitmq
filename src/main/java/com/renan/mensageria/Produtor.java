package com.renan.mensageria;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Produtor {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("mqadmin");
        connectionFactory.setPassword("Admin123XX_");

        String NOME_FILA = "FilaHelloWord";
        try(
                Connection connection = connectionFactory.newConnection();
                Channel channel = connection.createChannel();
                ){
            channel.queueDeclare(NOME_FILA, false, false, false, null);
            String mensagem = "Olá mundo 3 !";

            channel.basicPublish("", NOME_FILA, null, mensagem.getBytes());
            System.out.println("Enviei a mensagem: " + mensagem);
        }
    }
}
