---
title: Projet Services Web
author: ATTAL Hugo, THEAS-LABAN Alexis \& ZAIANI Yassine
date: Université Gustave Eiffel - 2022/2023
geometry: margin=2cm
output: pdf_document
---

---

## Introduction

Notre application est constitué de plusieurs services Java permettant aux étudiants et employés de louer, d'acheter et de vendre des vélos.

Ce projet est basé sur l'architecture RMI et le protocole SOAP.

Les Étudiants et Employés peuvent utiliser un système bancaire et effectuer des achats dans toutes les monnaies du monde.

## Choix de conception

### RenterRmi

*RenterRmi* est une application Java distribuée de gestion de  service de locations de vélos, fondée sur le middleware Java RMI.

### Services Web :

Nous avons réalisé un Service Web pour chaque service proposé par *Eiffel Bike Corp* :

#### GustaveBikeService

*GustaveBikeService* permet de consulter les prix des vélos, de vérifier leurs disponibilités, de les ajouter à un panier et de les acheter. 

#### BankService

*BankService* est utilisé par *GustaveBikeService* et permet de vérifier la disponibilité des fonds nécessaires à l'achat et effectuer le paiement.

#### Converter

*Converter* est utilisé par *BankService* et permet de convertir le prix des vélos dans la devise de l'acheteur. Le convertisseur trouve les taux de change en temps-réel grâce à  [l'API Fxtop](https://fxtop.com/) . (Cependant cette API ne fournit que les taux de change de 1999.)

## Difficultés Rencontrées

Nous avons rencontrés beaucoup de problèmes avec la configuration des différents Services Web sur Eclipse. En particulier, pour trouver la bonne combinaison des différentes versions de Java, Tomcat et Apache Axis à utiliser pour les faire fonctionner. Cela nous à obliger à restructer le projet à plusieurs reprises.

## Améliorations Possibles

- Une interface graphique pour les étudiants et employés leur permettant de louer, d’acheter et de vendre des vélos.
- Une interface graphique pour le client de *GustaveBikeService*, lui permettant de constituer un panier, le valider et payer.
- Une meilleur API pour le convertisseur pour avoir les taux de change actuels.
