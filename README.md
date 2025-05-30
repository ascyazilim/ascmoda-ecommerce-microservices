# ASC Moda - E-Ticaret Mikroservis Uygulaması

ASC Moda, Java Spring Boot ve React teknolojileri ile geliştirilen, kurumsal düzeyde bir e-ticaret platformudur. Proje, mikroservis mimarisi kullanılarak ölçeklenebilir ve bağımsız çalışabilen servisler halinde tasarlanmıştır.

---

## 🚀 Kullanılan Teknolojiler

### Backend
- Java 17
- Spring Boot
- Spring Cloud (Config Server, Eureka Discovery, API Gateway)
- PostgreSQL
- Redis
- RabbitMQ
- Docker

### Frontend (Geliştirilecek)
- React.js
- Material UI / Bootstrap

---

## 🧱 Mikroservis Yapısı

Her servis bağımsız olarak geliştirilmektedir. Maven çok modüllü yapı (multi-module) kullanılmaktadır.

- `config-server`: Merkezi yapılandırma servisi
- `eureka-server`: Servis keşfi ve load balancing
- `api-gateway`: Tüm trafiğin yönlendirildiği geçit servisi
- `user-service`: Kullanıcı işlemleri
- `product-service`: Ürün yönetimi
- `order-service`: Sipariş yönetimi
- `payment-service`: Ödeme yönetimi
- `notification-service`: E-posta / SMS bildirimleri (isteğe bağlı)

---
