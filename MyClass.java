import java.util.ArrayList;
import java.util.Objects;
public class MyClass {
    public static void main(String agr[]) {
        ArrayList<ArrayList<Integer>> combinacoes = obtemCombinacoes(); 
        ArrayList<ArrayList<ArrayList<Integer>>> conjuntoLinhasCoordenadasCombinacoes = obtemConjuntosCombinacoes(combinacoes);
        ArrayList<ArrayList<ArrayList<Integer>>> conjuntosValidos = validaConjuntos(conjuntoLinhasCoordenadasCombinacoes, combinacoes);
        System.out.println(conjuntosValidos.size());
    }
    static ArrayList<ArrayList<Integer>> obtemCombinacoes() {
        ArrayList<ArrayList<Integer>> combinacoes = new ArrayList<>();
        ArrayList<Integer> lista = new ArrayList<>();
        for(Integer i1 = 1; i1 < 14; i1++) {
            for(Integer i2 = i1+1; i2 < 15; i2++) {
                for(Integer i3 = i2+1; i3 < 16; i3++) {
                    for(Integer i4 = i3+1; i4 < 17; i4++) {
                        boolean todosDiferentes = (Objects.equals(i1, i2) || Objects.equals(i1, i3) || Objects.equals(i1, i4) || Objects.equals(i2, i3) || Objects.equals(i2, i4) || Objects.equals(i3, i4));
                        if(!todosDiferentes && i1+i2+i3+i4 == 34) { 
                            lista = new ArrayList<>();
                            lista.add(i1);
                            lista.add(i2);
                            lista.add(i3);
                            lista.add(i4);
                            combinacoes.add(lista);
                        }
                    }
                }
            }
        }
        return combinacoes;
    }

    static ArrayList<ArrayList<ArrayList<Integer>>> obtemConjuntosCombinacoes(ArrayList<ArrayList<Integer>> combinacoes) {
        ArrayList<ArrayList<ArrayList<Integer>>> conjuntosLinhas = new ArrayList<>();
        for(Integer i11 = 0; i11 < combinacoes.size(); i11++) {
            ArrayList<ArrayList<Integer>> combinacoes2 = retornaCombinacoesDiferentes(combinacoes, i11);
            for(Integer i12 = 0; i12 < combinacoes2.size(); i12++) {
                ArrayList<ArrayList<Integer>> combinacoes3 = retornaCombinacoesDiferentes(combinacoes2, i12);
                for(Integer i13 = 0; i13 < combinacoes3.size(); i13++) {
                    ArrayList<ArrayList<Integer>> combinacoes4 = retornaCombinacoesDiferentes(combinacoes3, i13);
                    for(Integer i14 = 0; i14 < combinacoes4.size(); i14++) {
                        ArrayList<ArrayList<Integer>> conjuntoLinhas = new ArrayList<>();
                        conjuntoLinhas.add(combinacoes.get(i11));
                        conjuntoLinhas.add(combinacoes2.get(i12));
                        conjuntoLinhas.add(combinacoes3.get(i13));
                        conjuntoLinhas.add(combinacoes4.get(i14));
                        conjuntosLinhas.add(conjuntoLinhas);
                    }
                }
            }
        }
        return conjuntosLinhas;
    }

    static ArrayList<ArrayList<Integer>> retornaCombinacoesDiferentes(ArrayList<ArrayList<Integer>> combinacoes, Integer index) {
        ArrayList<Integer> linha1 = combinacoes.get(index);
        ArrayList<ArrayList<Integer>> combinacoes2 = new ArrayList<>(); 
        for(Integer i2 = index + 1; i2 < combinacoes.size(); i2++) {
            boolean todosDiferentes = true;
            for(Integer i3 = 0; i3 < 4; i3++) {
                for(Integer i4 = 0; i4 < 4; i4++) {
                    if(Objects.equals(linha1.get(i3), combinacoes.get(i2).get(i4))) {
                        todosDiferentes = false;                        }
                }
            }
            if(todosDiferentes) {
                combinacoes2.add(combinacoes.get(i2));
            }
        }
        return combinacoes2;
    }

    static ArrayList<ArrayList<ArrayList<Integer>>> validaConjuntos(ArrayList<ArrayList<ArrayList<Integer>>> conjuntosLinhas, ArrayList<ArrayList<Integer>> combinacoes) {
        ArrayList<ArrayList<ArrayList<Integer>>> conjuntosValidos = new ArrayList<>();
        for(Integer indexConjunto = 0; indexConjunto < conjuntosLinhas.size(); indexConjunto++) {
            ArrayList<Integer> linha1 = conjuntosLinhas.get(indexConjunto).get(0);
            ArrayList<Integer> linha2 = conjuntosLinhas.get(indexConjunto).get(1);
            ArrayList<Integer> linha3 = conjuntosLinhas.get(indexConjunto).get(2);
            ArrayList<Integer> linha4 = conjuntosLinhas.get(indexConjunto).get(3);
            ArrayList<ArrayList<Integer>> colunas1 = obtenhaColunas(linha1.get(0), linha2, linha3, linha4);
            ArrayList<ArrayList<Integer>> colunas2 = obtenhaColunas(linha1.get(1), linha2, linha3, linha4);
            ArrayList<ArrayList<Integer>> colunas3 = obtenhaColunas(linha1.get(2), linha2, linha3, linha4);
            ArrayList<ArrayList<Integer>> colunas4 = obtenhaColunas(linha1.get(3), linha2, linha3, linha4);
            if(!colunas1.isEmpty() && !colunas2.isEmpty() && !colunas3.isEmpty() && !colunas4.isEmpty()) {
                boolean valido = tentaObterConjunto(colunas1, colunas2, colunas3, colunas4);
                if(valido) {
                    conjuntosValidos.add(conjuntosLinhas.get(indexConjunto));
                }
            }
        }
        return conjuntosValidos;
    }

    static ArrayList<ArrayList<Integer>> obtenhaColunas(Integer numero1, ArrayList<Integer> linha2, ArrayList<Integer> linha3, ArrayList<Integer> linha4) {
        ArrayList<ArrayList<Integer>> colunasPossiveis = new ArrayList<>();
        for(Integer indexLinha2 = 0; indexLinha2 < 4; indexLinha2++) {
            for(Integer indexLinha3 = 0; indexLinha3 < 4; indexLinha3++) {
                for(Integer indexLinha4 = 0; indexLinha4 < 4; indexLinha4++) {
                    if(numero1 + linha2.get(indexLinha2) + linha3.get(indexLinha3) + linha4.get(indexLinha4) == 34) {
                        ArrayList<Integer> coluna = new ArrayList<>();
                        coluna.add(numero1);
                        coluna.add(linha2.get(indexLinha2));
                        coluna.add(linha3.get(indexLinha3));
                        coluna.add(linha4.get(indexLinha4));
                        colunasPossiveis.add(coluna);
                    }
                }
            }
        }
        return colunasPossiveis;
    }

    static boolean tentaObterConjunto(ArrayList<ArrayList<Integer>> colunas1, ArrayList<ArrayList<Integer>> colunas2, ArrayList<ArrayList<Integer>> colunas3, ArrayList<ArrayList<Integer>> colunas4) {
        ArrayList<ArrayList<Integer>> diagonais1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> diagonais2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> normais1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> normais2 = new ArrayList<>();
        for(Integer index = 0; index < colunas1.size(); index++) {
            for(Integer index2 = 0; index2 < colunas4.size(); index2++) {
                if(colunas1.get(index).get(3) == colunas4.get(index2).get(3)) {
                    boolean todosDiferentes = true;
                    for(Integer i3 = 1; i3 < 3; i3++) {
                        for(Integer i4 = 1; i4 < 3; i4++) {
                            if(Objects.equals(colunas1.get(index).get(i3), colunas4.get(index2).get(i4))) {
                                todosDiferentes = false;                        }
                        }
                    }
                    if(todosDiferentes) {
                        diagonais1.add(colunas1.get(index));
                        diagonais2.add(colunas4.get(index2));
                    }  
                } else {
                    boolean todosDiferentes = true;
                    for(Integer i3 = 1; i3 < 3; i3++) {
                        for(Integer i4 = 1; i4 < 3; i4++) {
                            if(Objects.equals(colunas1.get(index).get(i3), colunas4.get(index2).get(i4))) {
                                todosDiferentes = false;                        }
                        }
                    }
                    if(todosDiferentes) {
                        normais1.add(colunas1.get(index));
                        normais2.add(colunas4.get(index2));
                    }
                }
            }
        }
        if(diagonais1.isEmpty() || diagonais2.isEmpty() || normais1.isEmpty() || normais2.isEmpty()) {
            return false;
        }
        ArrayList<ArrayList<Integer>> colunas2CompativeisComDiagonais = new ArrayList<>();
        ArrayList<ArrayList<Integer>> colunas3CompativeisComDiagonais = new ArrayList<>();
        for(Integer index = 0; index < colunas2.size(); index++) {
            boolean compativel1 = false;
            boolean compativel2 = false;
            for(Integer index2 = 0; index2 < diagonais1.size(); index2++) {
                if(colunas2.get(index).get(1) == diagonais1.get(index2).get(1) && colunas2.get(index).get(3) != diagonais1.get(index2).get(3)) {
                    compativel1 = true;
                }
            }
            for(Integer index2 = 0; index2 < diagonais2.size(); index2++) {
                if(colunas2.get(index).get(2) == diagonais2.get(index2).get(2) && colunas2.get(index).get(3) != diagonais2.get(index2).get(3)) {
                    compativel2 = true;
                }
            }
            if(compativel1 && compativel2) {
                colunas2CompativeisComDiagonais.add(colunas2.get(index));
            }
        }
        for(Integer index = 0; index < colunas3.size(); index++) {
            boolean compativel1 = false;
            boolean compativel2 = false;
            for(Integer index2 = 0; index2 < diagonais1.size(); index2++) {
                if(colunas3.get(index).get(2) == diagonais1.get(index2).get(2) && colunas3.get(index).get(3) != diagonais1.get(index2).get(3)) {
                    compativel1 = true;
                }
            }
            for(Integer index2 = 0; index2 < diagonais2.size(); index2++) {
                if(colunas3.get(index).get(1) == diagonais2.get(index2).get(1) && colunas3.get(index).get(3) != diagonais2.get(index2).get(3)) {
                    compativel2 = true;
                }
            }
            if(compativel1 && compativel2) {
                colunas3CompativeisComDiagonais.add(colunas3.get(index));
            }
        }
        if(colunas2CompativeisComDiagonais.isEmpty() || colunas3CompativeisComDiagonais.isEmpty()) {
            return false;
        }
        System.out.println("aaa");
        System.out.println(normais1.size());
        System.out.println(normais2.size());
        System.out.println(diagonais1.size());
        System.out.println(diagonais2.size());
        System.out.println(colunas2CompativeisComDiagonais.size());
        System.out.println(colunas3CompativeisComDiagonais.size());
        return true;
    }
}