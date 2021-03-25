package com.renan.mensageria;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumidor {
    public static void main(String[] args) throws Exception{
        System.out.println("Consumidor ativo");
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("mqadmin");
        connectionFactory.setPassword("Admin123XX_");

        String NOME_FILA = "FilaHelloWord";

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        DeliverCallback callback = (consumerTag, delivery) -> {
            String mensagem = new String(delivery.getBody());
            System.out.println("Recebi mensagem: " + mensagem);
        };

        channel.basicConsume(NOME_FILA, true, callback, consumerTag -> {});
    }
}
