# pglp_9.9
# Pour compiler et exécuter le projet:
mvn clean
mvn package
java -jar target/pglp_9.9-1.0-SNAPSHOT.jar
################################################################################################
# Guide d'utilisation une fois l'application exécutée   

 ----------------Format valide pour créer des figures :----------- 
 
 Création Rectangle: ---Re = Rectangle((origine_x, origine_y), (Longueur, largeur))           
Création Carre:  ------Ca = Carre((origine_x, origine_y), coté)                              
Création Cercle: ------Ce = Cercle((centre_x, centre_y ), rayon)                             
Création Triangle: ----Tr = Triangle((p1_x, p1_y ), (p2_x, p2_y ), (p3_x, p3_y ))              
Pour deplacer une forme: move(nom_figure, (p1_x, p1_y))                                     
Pour deplacer l'ensemble des formes: move(All, (p1_x, p1_y))                                 
Pour afficher une forme: view nom_forme                                                      
Pour quitter: exit                                                                           
Exemple de création:                                                                         
Ca = Carre((2, 5), 7)                                                                        
Re = Rectangle((3, 4), (4, 8))                                                               
Tr = Triangle((3, 4), (4, 8), (0, 0))                                                        
Ce = Cercle((2, 5), 7)                                                                       
move(Ce, (0, 0))                                                                             
view Ce                                                                                      
#################################################################################################
