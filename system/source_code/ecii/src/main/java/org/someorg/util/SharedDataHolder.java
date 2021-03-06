package org.someorg.util;

import org.someorg.datastructure.CandidateSolution;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SharedDataHolder {

    public static String programStartingDir;

    public static OWLDataFactory owlDataFactory;
    public static OWLOntologyManager owlOntologyManager;
    public static OWLOntology owlOntology;
    //public static OWLObjectProperty objPropImageContains;
    public static DLSyntaxRendererExt dlSyntaxRendererExt;

    public static String confFileFullContent;

    // by default all objectproperty have same score. based on the score we may choose to use certain object properties or not.
    public static HashMap<OWLObjectProperty, Double> objProperties = new HashMap<>();
    /**
     * Combination of objectProperties.
     */
    public static ArrayList<ArrayList<OWLObjectProperty>> objPropertiesCombination;
    public static final String noneObjPropStr = "__%!dop%!__";
    public static final OWLObjectProperty noneOWLObjProp = OWLManager.getOWLDataFactory().getOWLObjectProperty(IRI.create(noneObjPropStr));

    /**
     * Given positive individuals
     */
    public static HashSet<OWLNamedIndividual> posIndivs = new HashSet<>();
    /**
     * Given negative individuals
     */
    public static HashSet<OWLNamedIndividual> negIndivs = new HashSet<>();


    /**
     * Objects which are mentioned in the positive individuls using some object property.
     */
    public static HashMap<OWLObjectProperty, HashMap<OWLNamedIndividual, Integer>> objectsInPosIndivs = new HashMap<>();
    /**
     * Objects which are mentioned in the negative individuls using some object property.
     */
    public static HashMap<OWLObjectProperty, HashMap<OWLNamedIndividual, Integer>> objectsInNegIndivs = new HashMap<>();


    /**
     * Types of those objects which are mentioned in the positive individuals using some object property.
     * This is used to create the solution or to refine the solution.
     */
    public static HashMap<OWLObjectProperty, HashMap<OWLClassExpression, Integer>> typeOfObjectsInPosIndivs = new HashMap<>();
    /**
     * Types of those objects which are mentioned in the negative individuals using some object property.
     * This is used to create the solution or to refine the solution.
     */
    public static HashMap<OWLObjectProperty, HashMap<OWLClassExpression, Integer>> typeOfObjectsInNegIndivs = new HashMap<>();


    //@formatter:off
    /**
     *
     * Types of objects contained in the given individuals.
     * i.e. : All the types (of the objects) contained in the given inidviduals (given positive or negative individuals)
     * Example:
     *      posIndivs: posIndiv1, posindiv2.
     *      negIndivs: negIndiv1, negInidv2
     *      objectProperty: imageContains
     *
     *      Objects inside posIndivs and negIndivs using objectProperty:
     *          posIndiv1 imageContains obj1,
     *                                  obj2.
     *          posIndiv2 imageContains obj1,
     *                                  obj3,
     *          negIndiv1 imageContains ob4,
     *                                  ob5.
     *          negIndiv2 imageContains ob5,
     *                                  ob6.
     *          type(obj1) = t1, t7
     *          type(obj2) = t2, t8
     *          ..............
     *          type(obj6) = t6, t9
     *
     *      then, this hashmap will contain,
     *      HashMap<posIndiv1, <t1,t2,t7>>
     *      HashMap<posIndiv2, <t1,t3,t9>>
     *      HashMap<negIndiv2, <t5,t6,t9>>
     *          etc...
     *
     *
     * r1.concept1 has indi1
     * r2.concept2 has indi2
     * solution may create  r1.concept2 which is not acceptable
     * so we need to keep track of object proerties too.
     * this is used to calculate accuracy. This includes the direct types and super class of direct types.
     */
    //@formatter:on
    public static HashMap<OWLNamedIndividual, HashMap<OWLObjectProperty, HashSet<OWLClassExpression>>> individualHasObjectTypes = new HashMap<>();


    // score is inside of a solution
    // i.e. solution class contains the score also.
    public static HashSet<CandidateSolution> CandidateSolutionSet = new HashSet<>();

    public static ArrayList<CandidateSolution> SortedCandidateSolutionSet = new ArrayList<>();


}
