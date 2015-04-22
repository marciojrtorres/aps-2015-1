package game;

public class GameSimulador {

  private Personagem[] personagens;

  public GameSimulador(Personagem... personagens) {
    this.personagens = personagens;
  }

  public void simula() {
    while (naoHaApenasUmPersonagemVivo()) {
      Personagem um = pegaUmPersonagemVivo();
      Personagem outro = pegaOutroPersonagemVivoExceto(um);
      um.ataca(outro);
      try { Thread.sleep(100); } catch (Exception e) {}
    }
  }

  private boolean naoHaApenasUmPersonagemVivo() {
    int vivos = 0;
    for (Personagem p : personagens) if (p.getEnergia() > 0) vivos++;
    return vivos > 1;
  }

  private Personagem pegaUmPersonagemVivo() {
    while (true) {
      Personagem p = personagens[((int) (Math.random() * personagens.length))];
      if (p.getEnergia() > 0) return p;
    }
  }

  private Personagem pegaOutroPersonagemVivoExceto(Personagem um) {
    while (true) {
      Personagem p = personagens[((int) (Math.random() * personagens.length))];
      if (p.getEnergia() > 0 && !p.equals(um)) return p;
    }
  }

  public Personagem sobrou() {
    return pegaUmPersonagemVivo();
  }
}