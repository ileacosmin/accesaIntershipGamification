# accesaIntershipGamification
  Aceasta este o implementare minimală pentru un joc quiz. Aplicația se deschide prin fisierul Gamification și se pornește prin rularea fișierului Main.  
Pentru a începe jocul, trebuie să scrieți informațiile de autentificare ("cosmin" sau "ilea") în fereastra "LOGIN PAGE", după care începe jocul. Dacă știți răspunsul la întrebare, puteți sări peste ea, iar dacă dați submit cu un răspuns corect, numărul de token-uri se incrementează cu 1.

#Unelte folosite
javax.swing -> pentru JFrame și toate clasele aferente acesteia.  
java.util.Comparator -> pentru sortarea listei de jucători în funcție de comparator.  
java.io.Serializable -> pentru a putea scrie obiectele în fișierul binar.  
Am folosit un fișier binar pentru a citi datele și pentru a salva modificările făcute în timpul utilizării aplicației, odată cu închiderea ferestrei "Gamification".  
